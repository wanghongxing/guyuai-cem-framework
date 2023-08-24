package com.guyuai.framework.file.config;

import com.guyuai.framework.file.core.client.FileClientFactory;
import com.guyuai.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author 谷雨源码
 */
@AutoConfiguration
public class GuyuaiFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
