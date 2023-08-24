package com.guyuai.module.system.mq.producer.permission;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.permission.RoleRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private RoleProducer roleProducerUnderTest;

    @Test
    void testSendRoleRefreshMessage() {
        // Setup
        // Run the test
        roleProducerUnderTest.sendRoleRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final RoleRefreshMessage message = new RoleRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
