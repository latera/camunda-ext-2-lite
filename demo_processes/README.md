###### Business process template project

# Project structure
Project dependency management is done with Gradle. Gradle multiproject structure is used here in order to manage dependencies for the whole project, not for each business process separately.
Project dependencies are specified in the [build.gradle](build.gradle). Any extra dependencies should be added with `providedCompile` configuration in order to allow CI to copy the dependency jar to the docker image.
To add another business process it should be included to the project structure [configuration file](settings.gradle).
To manage project with Gradle Wrapper you should first get the wrapper jar itself: run `gradle wrapper` in the project directory. When the wrapper has been got, you are able to run `./gradlew ...`.

# Project build
To build separate business process and pack it to war archive you should run `./gradlew {business_process_code}:build`, where `business_process_code` is the code of the business process (actually, dir name).
To build the business process and pack it to the war archive deployable to Camunda you should run `./gradlew {business_process_code}}:war`. Created .war archive will be placed in `./{business_process_code}/build/libs/`.

# Linter
Ktlint plugin is applied to the project, so any build operations are accompanied by code style check.
To check your code style without project build run `./gradlew new_business_process:ktlintCheck`.
To format your code run `./gradlew new_business_process:ktlintFormat`.
