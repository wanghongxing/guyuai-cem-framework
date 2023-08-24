package com.guyuai.module.system.mq.message.notify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotifyTemplateRefreshMessageTest {

    private NotifyTemplateRefreshMessage notifyTemplateRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        notifyTemplateRefreshMessageUnderTest = new NotifyTemplateRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(notifyTemplateRefreshMessageUnderTest.getChannel()).isEqualTo("system.notify-template.refresh");
    }
}
