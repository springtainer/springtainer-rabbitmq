# springtainer-rabbitmq

[![Maven Central](https://img.shields.io/maven-central/v/com.avides.springboot.springtainer/springtainer-rabbitmq.svg?label=maven-central)](https://search.maven.org/artifact/com.avides.springboot.springtainer/springtainer-rabbitmq)
[![Release](https://github.com/springtainer/springtainer-rabbitmq/actions/workflows/release.yml/badge.svg)](https://github.com/springtainer/springtainer-rabbitmq/actions/workflows/release.yml)
[![Nightly build](https://github.com/springtainer/springtainer-rabbitmq/actions/workflows/nightly.yml/badge.svg)](https://github.com/springtainer/springtainer-rabbitmq/actions/workflows/nightly.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-rabbitmq&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-rabbitmq)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-rabbitmq&metric=coverage)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-rabbitmq)

### Dependency

```xml
<dependency>
  <groupId>com.avides.springboot.springtainer</groupId>
  <artifactId>springtainer-rabbitmq</artifactId>
  <version>2.0.0-RC2</version>
  <scope>test</scope>
</dependency>
```

### Configuration

Properties consumed (in `bootstrap.properties`):

- `embedded.container.rabbitmq.enabled` (default is `true`)
- `embedded.container.rabbitmq.startup-timeout` (default is `30`)
- `embedded.container.rabbitmq.docker-image` (default is `rabbitmq:3.13.7-alpine`)
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

## Spring's test-context cache is bounded automatically

`spring.test.context.cache.maxSize=1` ships as a classpath `spring.properties`
resource inside springtainer-common itself, so it's picked up automatically for every consumer - no configuration
needed on your side. This bounds Spring's test-context cache so a no-longer-current context (and, via its
`ContextClosedEvent` listener, its embedded container) gets evicted and cleanly closed as soon as a differently-configured
context needs the slot, instead of piling up unclosed until the whole JVM exits.

This works the same way whether tests are launched via Maven Surefire/Failsafe or directly from an IDE's own test
runner (e.g. Eclipse), since Spring resolves it from the classpath (`org.springframework.core.SpringProperties`) rather
than from a JVM system property.

## Logging

To reduce logging insert this into the logback-configuration:

```xml
<!-- Springtainer -->
<logger name="com.github.dockerjava" level="WARN" />
```

## Labels

The container exports multiple labels to analyze running springtainers:

- `SPRINGTAINER_SERVICE=rabbitmq`
- `SPRINGTAINER_IMAGE=${embedded.container.rabbitmq.docker-image}`
- `SPRINGTAINER_STARTED=$currentTimestamp`
