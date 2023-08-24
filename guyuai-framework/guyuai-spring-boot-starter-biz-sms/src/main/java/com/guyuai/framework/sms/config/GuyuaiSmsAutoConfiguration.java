package com.guyuai.framework.sms.config;

import com.guyuai.framework.sms.core.client.SmsClientFactory;
import com.guyuai.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author 谷雨源码
 */
@AutoConfiguration
public class GuyuaiSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
