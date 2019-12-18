package com.avides.springboot.springtainer.rabbitmq;

import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.rabbitmq.addresses=${embedded.container.rabbitmq.host}:${embedded.container.rabbitmq.port}" })
@DirtiesContext
public abstract class AbstractIT
{
    protected DockerClient dockerClient = DockerClientBuilder.getInstance().build();

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    protected RabbitAdmin rabbitAdmin;
}
