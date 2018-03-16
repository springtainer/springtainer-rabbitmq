springboot-testcontainers-rabbitmq
==================================

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.testcontainer/springboot-testcontainer-rabbitmq/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.testcontainer/springboot-testcontainer-rabbitmq)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/xxx)](https://www.codacy.com/app/springboot-testcontainer/springboot-testcontainer-rabbitmq)
[![Coverage Status](https://coveralls.io/repos/springboot-testcontainer/springboot-testcontainer-rabbitmq/badge.svg)](https://coveralls.io/r/springboot-testcontainer/springboot-testcontainer-rabbitmq)
[![Build Status](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-rabbitmq.svg?branch=master)](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-rabbitmq)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-rabbitmq</artifactId>
	<version>0.1.0-RC1</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap.properties`):
- `embedded.container.rabbitmq.enabled` (default is `true`)
- `embedded.container.rabbitmq.startup-timeout` (default is `30`)
- `embedded.container.rabbitmq.docker-image` (default is `rabbitmq:3.7.4-alpine`)
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
