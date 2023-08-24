package com.guyuai.module.system.mq.message.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmsSendMessageTest {

    private SmsSendMessage smsSendMessageUnderTest;

    @BeforeEach
    void setUp() {
        smsSendMessageUnderTest = new SmsSendMessage();
    }

    @Test
    void testGetStreamKey() {
        assertThat(smsSendMessageUnderTest.getStreamKey()).isEqualTo("system.sms.send");
    }
}
