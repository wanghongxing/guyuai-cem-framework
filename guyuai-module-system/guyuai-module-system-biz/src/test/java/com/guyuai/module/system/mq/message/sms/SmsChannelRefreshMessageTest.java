package com.guyuai.module.system.mq.message.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmsChannelRefreshMessageTest {

    private SmsChannelRefreshMessage smsChannelRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        smsChannelRefreshMessageUnderTest = new SmsChannelRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(smsChannelRefreshMessageUnderTest.getChannel()).isEqualTo("system.sms-channel.refresh");
    }
}
