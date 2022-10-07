#!/bin/bash

if [ "x${BPM_DB_SEED}" == "x" ]; then
   echo "[BPM_DB_SEED] Skip seed"
   exit 0
fi

camunda=${CAMUNDA_ADDR:-http://localhost:8080}

admin_data() {
   cat <<EOF
{
  "profile": {
    "id": "${BPM_USER:-user@example.com}",
    "firstName": "${BPM_USER_FIRSTNAME:-Administrator}",
    "lastName": "${BPM_USER_LASTNAME:-Camunda}",
    "email": "${BPM_USER_EMAIL:-user@example.com}"
  },
  "credentials": {
    "password": "${BPM_PASSWORD:-changeme}"
  }
}
EOF
}

camunda_up=0

while [ ${camunda_up} == 0 ]; do

   echo "[BPM_DB_SEED] wait for camunda... ${camunda}"
   check_camunda_response=$(curl -L -s -c /tmp/cookie --connect-timeout 3 "${camunda}/camunda/" | grep -ic 'Camunda Welcome')

   if [ $check_camunda_response -gt 0 ]; then
      echo "[BPM_DB_SEED] camunda is up"

      xsrf_token=$(grep 'XSRF-TOKEN' /tmp/cookie | sed -r 's/^.*[\ \t]+//')

      create_admin_response=$(curl -L -s -w "%{http_code}" -o /dev/null -H "Content-Type:application/json" -H "X-XSRF-TOKEN: ${xsrf_token}" -b /tmp/cookie --data "$(admin_data)" "${camunda}/camunda/api/admin/setup/default/user/create")
      echo "[BPM_DB_SEED] create_admin_response_code: ${create_admin_response:-No content}"

      camunda_up=1
   fi

   sleep 5

done
