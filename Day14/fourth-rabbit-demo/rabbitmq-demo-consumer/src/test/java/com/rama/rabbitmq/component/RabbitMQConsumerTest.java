package com.rama.rabbitmq.component;

import com.rama.rabbitmq.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
class RabbitMQConsumerTest {

    @Test
    void converter() {
        Jackson2JsonMessageConverter message = mock(RabbitMQConsumer.class).converter();
        Jackson2JsonMessageConverter res = new Jackson2JsonMessageConverter();
        assertEquals(message,res);
    }

    @Test
    void recievedMessage() {
        doNothing().when(mock(RabbitMQConsumer.class)).recievedMessage(new Employee());
        //verify(rabbitMQConsumer,times(1)).recievedMessage(new Employee());
    }
}