package com.guyuai.module.system.mq.message.permission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRefreshMessageTest {

    private MenuRefreshMessage menuRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        menuRefreshMessageUnderTest = new MenuRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(menuRefreshMessageUnderTest.getChannel()).isEqualTo("system.menu.refresh");
    }
}
