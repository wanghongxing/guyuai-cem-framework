package com.guyuai.module.system.mq.producer.auth;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.auth.OAuth2ClientRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OAuth2ClientProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private OAuth2ClientProducer oAuth2ClientProducerUnderTest;

    @Test
    void testSendOAuth2ClientRefreshMessage() {
        // Setup
        // Run the test
        oAuth2ClientProducerUnderTest.sendOAuth2ClientRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final OAuth2ClientRefreshMessage message = new OAuth2ClientRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
