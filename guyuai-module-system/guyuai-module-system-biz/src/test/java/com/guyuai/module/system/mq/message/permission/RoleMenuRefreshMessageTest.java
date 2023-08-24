package com.guyuai.module.system.mq.message.permission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoleMenuRefreshMessageTest {

    private RoleMenuRefreshMessage roleMenuRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        roleMenuRefreshMessageUnderTest = new RoleMenuRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(roleMenuRefreshMessageUnderTest.getChannel()).isEqualTo("system.role-menu.refresh");
    }
}
