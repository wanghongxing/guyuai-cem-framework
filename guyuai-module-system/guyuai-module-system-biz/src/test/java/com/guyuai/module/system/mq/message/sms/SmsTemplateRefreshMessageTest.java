package com.guyuai.module.system.mq.message.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmsTemplateRefreshMessageTest {

    private SmsTemplateRefreshMessage smsTemplateRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        smsTemplateRefreshMessageUnderTest = new SmsTemplateRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(smsTemplateRefreshMessageUnderTest.getChannel()).isEqualTo("system.sms-template.refresh");
    }
}
