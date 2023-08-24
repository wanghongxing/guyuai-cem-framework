package com.guyuai.module.system.mq.producer.sms;

import com.guyuai.framework.common.core.KeyValue;
import com.guyuai.framework.mq.core.RedisMQTemplate;
import com.guyuai.module.system.mq.message.sms.SmsChannelRefreshMessage;
import com.guyuai.module.system.mq.message.sms.SmsSendMessage;
import com.guyuai.module.system.mq.message.sms.SmsTemplateRefreshMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SmsProducerTest {

    @Mock
    private RedisMQTemplate mockRedisMQTemplate;

    @InjectMocks
    private SmsProducer smsProducerUnderTest;

    @Test
    void testSendSmsChannelRefreshMessage() {
        // Setup
        // Run the test
        smsProducerUnderTest.sendSmsChannelRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final SmsChannelRefreshMessage message = new SmsChannelRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }

    @Test
    void testSendSmsTemplateRefreshMessage() {
        // Setup
        // Run the test
        smsProducerUnderTest.sendSmsTemplateRefreshMessage();

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final SmsTemplateRefreshMessage message = new SmsTemplateRefreshMessage();
        verify(mockRedisMQTemplate).send(message);
    }

    @Test
    void testSendSmsSendMessage() {
        // Setup
        final List<KeyValue<String, Object>> templateParams = Arrays.asList(new KeyValue<>("key", "value"));

        // Run the test
        smsProducerUnderTest.sendSmsSendMessage(0L, "mobile", 0L, "apiTemplateId", templateParams);

        // Verify the results
        // Confirm RedisMQTemplate.send(...).
        final SmsSendMessage message = new SmsSendMessage();
        message.setLogId(0L);
        message.setMobile("mobile");
        message.setChannelId(0L);
        message.setApiTemplateId("apiTemplateId");
        message.setTemplateParams(Arrays.asList(new KeyValue<>("key", "value")));
        verify(mockRedisMQTemplate).send(message);
    }
}
