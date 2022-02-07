# springtainer-rabbitmq

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.springtainer/springtainer-rabbitmq/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.springtainer/springtainer-rabbitmq)
[![Build](https://github.com/springtainer/springtainer-rabbitmq/workflows/release/badge.svg)](https://github.com/springtainer/springtainer-rabbitmq/actions)
[![Nightly build](https://github.com/springtainer/springtainer-rabbitmq/workflows/nightly/badge.svg)](https://github.com/springtainer/springtainer-rabbitmq/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-rabbitmq&metric=coverage)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-rabbitmq)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-rabbitmq&metric=alert_status)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-rabbitmq)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-rabbitmq&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-rabbitmq)

### Dependency

```xml

<dependency>
  <groupId>com.avides.springboot.springtainer</groupId>
  <artifactId>springtainer-rabbitmq</artifactId>
  <version>1.3.0</version>
  <scope>test</scope>
</dependency>
```

### Configuration

Properties consumed (in `bootstrap.properties`):

- `embedded.container.rabbitmq.enabled` (default is `true`)
- `embedded.container.rabbitmq.startup-timeout` (default is `30`)
- `embedded.container.rabbitmq.docker-image` (default is `rabbitmq:3.9.13-alpine`)
- `embedded.container.rabbitmq.port` (default is `5672`)
- `embedded.container.rabbitmq.virtual-host` (default is `/`)
- `embedded.container.rabbitmq.username` (default is `guest`)
- `embedded.container.rabbitmq.password` (default is `guest`)

Properties provided (in `application-it.properties`):

- `embedded.container.rabbitmq.host`
- `embedded.container.rabbitmq.port`

Example for minimal configuration in `application-it.properties`:

```
spring.rabbitmq.addresses=${embedded.container.rabbitmq.host}:${embedded.container.rabbitmq.port}
```

## Logging

To reduce logging insert this into the logback-configuration:

```xml
<!-- Springtainer -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels

The container exports multiple labels to analyze running springtainers:

- `SPRINGTAINER_SERVICE=rabbitmq`
- `SPRINGTAINER_IMAGE=${embedded.container.rabbitmq.docker-image}`
- `SPRINGTAINER_STARTED=$currentTimestamp`
