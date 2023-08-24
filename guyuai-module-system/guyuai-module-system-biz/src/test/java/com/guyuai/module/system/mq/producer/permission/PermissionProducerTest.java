package com.guyuai.module.system.mq.producer.permission;

import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.permission.RoleMenuRefreshMessage;
import com.guyuai.module.system.mq.message.permission.UserRoleRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PermissionProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private PermissionProducer permissionProducerUnderTest;

    @Test
    void testSendRoleMenuRefreshMessage() {
        // Setup
        // Run the test
        permissionProducerUnderTest.sendRoleMenuRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final RoleMenuRefreshMessage message = new RoleMenuRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }

    @Test
    void testSendUserRoleRefreshMessage() {
        // Setup
        // Run the test
        permissionProducerUnderTest.sendUserRoleRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final UserRoleRefreshMessage message = new UserRoleRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }
}
