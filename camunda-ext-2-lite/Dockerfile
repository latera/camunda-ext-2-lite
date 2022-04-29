FROM gradle:7.1.1

COPY ./lib ./gradle ./gradlew ./settings.gradle ./gradlew.bat /app/

WORKDIR /app

RUN gradle wrapper && ./gradlew clean build

