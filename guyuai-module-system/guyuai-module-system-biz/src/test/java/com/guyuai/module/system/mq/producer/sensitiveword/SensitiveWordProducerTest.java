package com.guyuai.module.system.mq.producer.sensitiveword;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.sensitiveword.SensitiveWordRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SensitiveWordProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private SensitiveWordProducer sensitiveWordProducerUnderTest;

    @Test
    void testSendSensitiveWordRefreshMessage() {
        // Setup
        // Run the test
        sensitiveWordProducerUnderTest.sendSensitiveWordRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final SensitiveWordRefreshMessage message = new SensitiveWordRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
