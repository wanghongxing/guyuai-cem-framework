package com.guyuai.module.system.mq.message.permission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRoleRefreshMessageTest {

    private UserRoleRefreshMessage userRoleRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        userRoleRefreshMessageUnderTest = new UserRoleRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(userRoleRefreshMessageUnderTest.getChannel()).isEqualTo("system.user-role.refresh");
    }
}
