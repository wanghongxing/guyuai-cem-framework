package com.guyuai.module.system.mq.message.mail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MailAccountRefreshMessageTest {

    private MailAccountRefreshMessage mailAccountRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        mailAccountRefreshMessageUnderTest = new MailAccountRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(mailAccountRefreshMessageUnderTest.getChannel()).isEqualTo("system.mail-account.refresh");
    }
}
