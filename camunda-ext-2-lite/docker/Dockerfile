# build camunda-ext-2
FROM gradle:7.1.1 as camunda-ext-2

COPY ./lib ./gradle ./gradlew ./settings.gradle ./gradlew.bat /app/

WORKDIR /app

RUN gradle wrapper && \
    ./gradlew clean build && \
    gradle copyDependencies

# build image
FROM camunda/camunda-bpm-platform:7.14.0

RUN sed -i '/^exec /i /camunda/seed_db.sh &' camunda.sh && \
    sed -i 's/^exec .*/${CMD}/' camunda.sh && \
    rm -rf /camunda/webapps/camunda-invoice && \
    rm -f /camunda/lib/slf4j-* && \
    xmlstarlet ed -L -s '/_:bpm-platform/_:process-engine/_:properties' -t elem -n property -v "[a-zA-Z0-9-@\.]*" -i '/_:bpm-platform/_:process-engine/_:properties/property' -t attr -n name -v "userResourceWhitelistPattern" /camunda/conf/bpm-platform.xml

COPY --chown=camunda:camunda ./docker/seed_db.sh /camunda/

COPY --from=camunda-ext-2 --chown=camunda:camunda /app/lib/*.jar /camunda/lib/
COPY --from=camunda-ext-2 --chown=camunda:camunda /app/build/libs/*.jar /camunda/lib/
