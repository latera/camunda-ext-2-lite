#!/bin/bash
set -Eeu

trap 'Error on line $LINENO' ERR

# Use exising tomcat ditribution if present..
CATALINA_HOME="${CATALINA_HOME:-/camunda}"

# Set default values for DB_ variables
# Set Password as Docker Secrets for Swarm-Mode
if [[ -z "${DB_PASSWORD:-}" && -n "${DB_PASSWORD_FILE:-}" && -f "${DB_PASSWORD_FILE:-}" ]]; then
  export DB_PASSWORD="$(< "${DB_PASSWORD_FILE}")"
fi

export "DB_TYPE=${DB_TYPE:-postgresql}"
export "DB_DRIVER=${DB_DRIVER:-${BPM_DB_DRIVER-}}"
export "DB_PASSWORD=${DB_PASSWORD:-${BPM_DB_PASSWORD-}}"
export "DB_HOST=${DB_HOST:-${BPM_DB_HOST-}}"
export "DB_PORT=${DB_PORT:-${BPM_DB_PORT-}}"
export "DB_NAME=${DB_NAME:-${BPM_DB_NAME-}}"
export "DB_USERNAME=${DB_USERNAME:-${BPM_DB_USER-}}"

if [[ "$DB_TYPE" == "postgresql" ]]; then
  if [[ "x$DB_URL" == "x" ]]; then
    export DB_URL="jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}"
  fi
  if [[ "x$DB_DRIVER" == "x" ]]; then
    export DB_DRIVER="org.postgresql.Driver"
  fi
fi

XML_JDBC="//Resource[@name='jdbc/ProcessEngine']"
XML_DRIVER="${XML_JDBC}/@driverClassName"
XML_URL="${XML_JDBC}/@url"
XML_USERNAME="${XML_JDBC}/@username"
XML_PASSWORD="${XML_JDBC}/@password"
XML_MAXTOTAL="${XML_JDBC}/@maxTotal"
XML_MINIDLE="${XML_JDBC}/@minIdle"
XML_MAXIDLE="${XML_JDBC}/@maxIdle"

if [ -z "$SKIP_DB_CONFIG" ]; then
  echo "Configure database"
  xmlstarlet ed -L \
    -u "${XML_DRIVER}" -v "${DB_DRIVER}" \
    -u "${XML_URL}" -v "${DB_URL}" \
    -u "${XML_USERNAME}" -v "${DB_USERNAME}" \
    -u "${XML_PASSWORD}" -v "${DB_PASSWORD}" \
    -u "${XML_MAXTOTAL}" -v "${DB_CONN_MAXACTIVE}" \
    -u "${XML_MINIDLE}" -v "${DB_CONN_MINIDLE}" \
    -u "${XML_MAXIDLE}" -v "${DB_CONN_MAXIDLE}" \
    -u "${XML_JDBC}/@testOnBorrow" -v "${DB_VALIDATE_ON_BORROW}" \
    -i "${XML_JDBC}[not(@testOnBorrow)]" -t attr -n "testOnBorrow" -v "${DB_VALIDATE_ON_BORROW}" \
    -u "${XML_JDBC}/@validationQuery" -v "${DB_VALIDATION_QUERY}" \
    -i "${XML_JDBC}[not(@validationQuery)]" -t attr -n "validationQuery" -v "${DB_VALIDATION_QUERY}" \
    "${CATALINA_HOME}/conf/server.xml"
fi

export HISTORY_LEVEL="${HISTORY_LEVEL:-${BPM_HISTORY_LEVEL:-none}}"

XML_PLATFORM_NAMESPACE="http://www.camunda.org/schema/1.0/BpmPlatform"
XML_PLATFORM_PROPERTIES="//xmlns:bpm-platform/xmlns:process-engine/xmlns:properties/xmlns:property"
XML_PLATFORM_HISTORY_LEVEL="${XML_PLATFORM_PROPERTIES}[@name='history']"

echo "Configure bpm platform"
xmlstarlet ed -L \
  -N xmlns="${XML_PLATFORM_NAMESPACE}" -u "${XML_PLATFORM_HISTORY_LEVEL}" -v "${HISTORY_LEVEL}" \
  /camunda/conf/bpm-platform.xml

CMD="${CATALINA_HOME}/bin/catalina.sh"
if [ "${DEBUG}" = "true" ]; then
  echo "Enabling debug mode, JPDA accesible under port 8000"
  export JPDA_ADDRESS="0.0.0.0:8000"
  CMD+=" jpda"
fi

if [ "$JMX_PROMETHEUS" = "true" ] ; then
  echo "Enabling Prometheus JMX Exporter on port ${JMX_PROMETHEUS_PORT}"
  [ ! -f "$JMX_PROMETHEUS_CONF" ] && touch "$JMX_PROMETHEUS_CONF"
  export CATALINA_OPTS="-javaagent:/camunda/javaagent/jmx_prometheus_javaagent.jar=${JMX_PROMETHEUS_PORT}:${JMX_PROMETHEUS_CONF}"
fi

CMD+=" run"

if [ -n "${WAIT_FOR}" ]; then
  CMD="wait-for-it.sh ${WAIT_FOR} -s -t ${WAIT_FOR_TIMEOUT} -- ${CMD}"
fi

# shellcheck disable=SC2086
/camunda/seed_db.sh &
${CMD}
