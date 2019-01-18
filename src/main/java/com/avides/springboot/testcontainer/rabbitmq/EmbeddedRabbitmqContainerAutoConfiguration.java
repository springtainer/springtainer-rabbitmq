package com.avides.springboot.testcontainer.rabbitmq;

import static com.avides.springboot.testcontainer.rabbitmq.RabbitmqProperties.BEAN_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

import com.avides.springboot.testcontainer.common.container.AbstractBuildingEmbeddedContainer;
import com.avides.springboot.testcontainer.common.container.EmbeddedContainer;
import com.rabbitmq.client.ConnectionFactory;

import lombok.SneakyThrows;

@Configuration
@ConditionalOnProperty(name = "embedded.container.rabbitmq.enabled", matchIfMissing = true)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(RabbitmqProperties.class)
public class EmbeddedRabbitmqContainerAutoConfiguration
{
    @ConditionalOnMissingBean(RabbitmqContainer.class)
    @Bean(BEAN_NAME)
    public EmbeddedContainer rabbitmqContainer(ConfigurableEnvironment environment, RabbitmqProperties properties)
    {
        return new RabbitmqContainer("rabbitmq", environment, properties);
    }

    public class RabbitmqContainer extends AbstractBuildingEmbeddedContainer<RabbitmqProperties>
    {
        public RabbitmqContainer(String service, ConfigurableEnvironment environment, RabbitmqProperties properties)
        {
            super(service, environment, properties);
        }

        @Override
        protected List<String> getEnvs()
        {
            List<String> envs = new ArrayList<>();
            envs.add("RABBITMQ_DEFAULT_USER=" + properties.getUsername());
            envs.add("RABBITMQ_DEFAULT_PASS=" + properties.getPassword());
            envs.add("RABBITMQ_DEFAULT_VHOST=" + properties.getVirtualHost());
            return envs;
        }

        @Override
        protected List<String> getTmpDirectories()
        {
            return Collections.singletonList("/var/lib/rabbitmq");
        }

        @Override
        protected Map<String, Object> providedProperties()
        {
            Map<String, Object> provided = new HashMap<>();
            provided.put("embedded.container.rabbitmq.host", getContainerHost());
            provided.put("embedded.container.rabbitmq.port", Integer.valueOf(getContainerPort(properties.getPort())));
            return provided;
        }

        @SneakyThrows
        @Override
        protected boolean isContainerReady(RabbitmqProperties properties)
        {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(getContainerHost());
            factory.setPort(getContainerPort(properties.getPort()));
            factory.setVirtualHost(properties.getVirtualHost());
            factory.setUsername(properties.getUsername());
            factory.setPassword(properties.getPassword());
            factory.setExceptionHandler(new NoLoggingExceptionHandler());
            factory.newConnection();
            return true;
        }
    }
}
