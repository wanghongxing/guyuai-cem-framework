package com.guyuai.module.system.mq.message.sensitiveword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SensitiveWordRefreshMessageTest {

    private SensitiveWordRefreshMessage sensitiveWordRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        sensitiveWordRefreshMessageUnderTest = new SensitiveWordRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(sensitiveWordRefreshMessageUnderTest.getChannel()).isEqualTo("system.sensitive-word.refresh");
    }
}
