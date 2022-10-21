# build camunda-ext-2
FROM gradle:7.1.1 as camunda-ext-2-lite

COPY ./lib ./gradle ./gradlew ./settings.gradle ./gradlew.bat /app/

WORKDIR /app

ARG VERSION

ENV VERSION=${VERSION}

RUN gradle wrapper && \
    ./gradlew clean build && \
    gradle copyDependencies

# build image
FROM camunda/camunda-bpm-platform:7.14.0

RUN rm -rf /camunda/webapps/camunda-invoice && \
    rm -f /camunda/lib/slf4j-*

COPY --chown=camunda:camunda ./docker/seed_db.sh /camunda/
COPY --chown=camunda:camunda ./docker/camunda.sh /camunda/
COPY --chown=camunda:camunda ./docker/conf/bpm-platform.xml /camunda/conf/

COPY --from=camunda-ext-2-lite --chown=camunda:camunda /app/lib/*.jar /camunda/lib/
COPY --from=camunda-ext-2-lite --chown=camunda:camunda /app/build/libs/*.jar /camunda/lib/
