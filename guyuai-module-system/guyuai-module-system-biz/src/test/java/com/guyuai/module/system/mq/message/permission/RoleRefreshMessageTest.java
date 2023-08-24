package com.guyuai.module.system.mq.message.permission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoleRefreshMessageTest {

    private RoleRefreshMessage roleRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        roleRefreshMessageUnderTest = new RoleRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(roleRefreshMessageUnderTest.getChannel()).isEqualTo("system.role.refresh");
    }
}
