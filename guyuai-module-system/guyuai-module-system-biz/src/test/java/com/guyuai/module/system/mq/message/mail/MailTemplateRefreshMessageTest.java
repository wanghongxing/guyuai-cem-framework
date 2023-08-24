package com.guyuai.module.system.mq.message.mail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MailTemplateRefreshMessageTest {

    private MailTemplateRefreshMessage mailTemplateRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        mailTemplateRefreshMessageUnderTest = new MailTemplateRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(mailTemplateRefreshMessageUnderTest.getChannel()).isEqualTo("system.mail-template.refresh");
    }
}
