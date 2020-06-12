package com.avides.springboot.springtainer.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.avides.springboot.springtainer.common.container.AbstractEmbeddedContainerProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties("embedded.container.rabbitmq")
@Getter
@Setter
@ToString(callSuper = true)
public class RabbitmqProperties extends AbstractEmbeddedContainerProperties
{
    public static final String BEAN_NAME = "embeddedRabbitmqContainer";

    private int port = 5672;

    private String virtualHost = "/";

    private String username = "guest";

    private String password = "guest"; // NOSONAR

    public RabbitmqProperties()
    {
        setDockerImage("rabbitmq:3.8.4-alpine");
    }
}
