package com.guyuai.module.system.mq.message.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OAuth2ClientRefreshMessageTest {

    private OAuth2ClientRefreshMessage oAuth2ClientRefreshMessageUnderTest;

    @BeforeEach
    void setUp() {
        oAuth2ClientRefreshMessageUnderTest = new OAuth2ClientRefreshMessage();
    }

    @Test
    void testGetChannel() {
        assertThat(oAuth2ClientRefreshMessageUnderTest.getChannel()).isEqualTo("system.oauth2-client.refresh");
    }
}
