package com.avides.springboot.testcontainer.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.avides.springboot.testcontainer.common.container.AbstractEmbeddedContainerProperties;

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
        setDockerImage("rabbitmq:3.7.8-alpine");
    }
}
