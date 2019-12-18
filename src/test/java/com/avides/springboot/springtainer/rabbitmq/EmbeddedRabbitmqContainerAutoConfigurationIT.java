package com.avides.springboot.springtainer.rabbitmq;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

public class EmbeddedRabbitmqContainerAutoConfigurationIT extends AbstractIT
{
    @Test
    public void testGeneratedProperties()
    {
        assertThat(environment.getProperty("embedded.container.rabbitmq.host")).isNotEmpty();
        assertThat(environment.getProperty("embedded.container.rabbitmq.port")).isNotEmpty();

        System.out.println();
        System.out.println("Resolved properties:");
        System.out.println("Host:         " + environment.getProperty("embedded.container.rabbitmq.host"));
        System.out.println("Port:         " + environment.getProperty("embedded.container.rabbitmq.port"));
        System.out.println("Virtual-Host: " + environment.getProperty("embedded.container.rabbitmq.virtual-host"));
        System.out.println("Username:     " + environment.getProperty("embedded.container.rabbitmq.username"));
        System.out.println("Password:     " + environment.getProperty("embedded.container.rabbitmq.password"));
        System.out.println();
    }

    @Test
    public void testCreateQueue()
    {
        rabbitAdmin.declareQueue(new Queue("foo"));
        assertThat(rabbitAdmin.getQueueProperties("foo")).isNotNull();
        assertThat(rabbitAdmin.getQueueProperties("bar")).isNull();
    }

    @Configuration
    @EnableAutoConfiguration
    static class TestConfiguration
    {
        // nothing
    }
}
