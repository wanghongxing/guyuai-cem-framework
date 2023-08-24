package com.guyuai.module.system.mq.message.dept;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeptRefreshMessageTest {

    private DeptRefreshMessage deptRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        deptRefreshMessageUnderTest = new DeptRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(deptRefreshMessageUnderTest.getChannel()).isEqualTo("system.dept.refresh");
    }
}
