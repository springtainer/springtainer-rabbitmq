package com.avides.springboot.springtainer.rabbitmq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RabbitmqPropertiesTest
{
    @Test
    public void testDefaults()
    {
        var properties = new RabbitmqProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("rabbitmq:3.11.10-alpine", properties.getDockerImage());

        assertEquals(5672, properties.getPort());
        assertEquals("/", properties.getVirtualHost());
        assertEquals("guest", properties.getUsername());
        assertEquals("guest", properties.getPassword());
    }
}
