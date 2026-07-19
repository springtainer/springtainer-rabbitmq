package com.avides.springboot.springtainer.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RabbitmqPropertiesTest
{
    @Test
    public void testDefaults()
    {
        var properties = new RabbitmqProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("rabbitmq:3.13.7-alpine", properties.getDockerImage());

        assertEquals(5672, properties.getPort());
        assertEquals("/", properties.getVirtualHost());
        assertEquals("guest", properties.getUsername());
        assertEquals("guest", properties.getPassword());
    }
}
