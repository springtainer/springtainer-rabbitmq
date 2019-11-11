# springboot-testcontainer-rabbitmq

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-rabbitmq/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-rabbitmq%22)
[![Build](https://github.com/springboot-testcontainer/springboot-testcontainer-rabbitmq/workflows/release/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-rabbitmq/actions)
[![Nightly build](https://github.com/springboot-testcontainer/springboot-testcontainer-rabbitmq/workflows/nightly/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-rabbitmq/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-rabbitmq&metric=coverage)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-rabbitmq)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-rabbitmq&metric=alert_status)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-rabbitmq)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-rabbitmq&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-rabbitmq)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-rabbitmq</artifactId>
	<version>1.0.0-RC2</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap.properties`):
- `embedded.container.rabbitmq.enabled` (default is `true`)
- `embedded.container.rabbitmq.startup-timeout` (default is `30`)
- `embedded.container.rabbitmq.docker-image` (default is `rabbitmq:3.8.1-alpine`)
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
<!-- Testcontainers -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels
The container exports multiple labels to analyze running testcontainers:
- `TESTCONTAINER_SERVICE=rabbitmq`
- `TESTCONTAINER_IMAGE=${embedded.container.rabbitmq.docker-image}`
- `TESTCONTAINER_STARTED=$currentTimestamp`
