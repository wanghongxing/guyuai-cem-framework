package com.guyuai.framework.pay.config;

import com.guyuai.framework.pay.core.client.PayClientFactory;
import com.guyuai.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author 谷雨源码
 */
@AutoConfiguration
@EnableConfigurationProperties(PayProperties.class)
public class GuyuaiPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
