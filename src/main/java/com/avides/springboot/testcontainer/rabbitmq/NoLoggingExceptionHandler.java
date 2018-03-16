package com.avides.springboot.testcontainer.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.TopologyRecoveryException;

public class NoLoggingExceptionHandler implements ExceptionHandler
{
    @Override
    public void handleUnexpectedConnectionDriverException(Connection conn, Throwable exception)
    {
        // no logging necessary
    }

    @Override
    public void handleTopologyRecoveryException(Connection conn, Channel ch, TopologyRecoveryException exception)
    {
        // no logging necessary
    }

    @Override
    public void handleReturnListenerException(Channel channel, Throwable exception)
    {
        // no logging necessary
    }

    @Override
    public void handleConsumerException(Channel channel, Throwable exception, Consumer consumer, String consumerTag, String methodName)
    {
        // no logging necessary
    }

    @Override
    public void handleConnectionRecoveryException(Connection conn, Throwable exception)
    {
        // no logging necessary
    }

    @Override
    public void handleConfirmListenerException(Channel channel, Throwable exception)
    {
        // no logging necessary
    }

    @Override
    public void handleChannelRecoveryException(Channel ch, Throwable exception)
    {
        // no logging necessary
    }

    @Override
    public void handleBlockedListenerException(Connection connection, Throwable exception)
    {
        // no logging necessary
    }
}
