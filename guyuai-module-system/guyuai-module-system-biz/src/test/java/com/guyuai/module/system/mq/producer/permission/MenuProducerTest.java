package com.guyuai.module.system.mq.producer.permission;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.permission.MenuRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MenuProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private MenuProducer menuProducerUnderTest;

    @Test
    void testSendMenuRefreshMessage() {
        // Setup
        // Run the test
        menuProducerUnderTest.sendMenuRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final MenuRefreshMessage message = new MenuRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
