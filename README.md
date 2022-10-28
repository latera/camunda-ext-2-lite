# Camunda Extensions

Camunda-ext-2-lite is an open source part of the camunda-ext-2 library used to relief integration of business process with Hydra components and other systems.
Camunda-ext-2-lite includes the only connector - Hydra OMS connector, all other connects should be designed in the same way.

### Requirements
* [Docker](https://docker.com/)
* [docker-compose](https://docs.docker.com/compose/install/)
* [Gradle](https://gradle.org/) `1.4.31`

### Compatibility
* [Camunda 7.14.0 compatible](https://docs.camunda.org/manual/7.14/introduction/) PostgreSQL 9.4 / 9.6 / 10 / 11 / 12
* [Hydra OMS](https://hub.docker.com/r/latera/homs) 2.7.0 and later
* [Minio](https://github.com/minio/minio/releases/tag/RELEASE.2021-06-17T00-10-46Z)

### Resources
* Documentation: https://github.com/hydra-billing/camunda-ext-2-lite/tree/master/docs
* Tickets/Issues: https://github.com/hydra-billing/camunda-ext-2-lite/issues
* Hydra OMS: https://github.com/hydra-billing/homs

## Installation
Edit `.env` file if needed, then run
`docker-compose up -d`

Ports and credentials for Camunda, Minio, Hydra OMS are set in `env`.
