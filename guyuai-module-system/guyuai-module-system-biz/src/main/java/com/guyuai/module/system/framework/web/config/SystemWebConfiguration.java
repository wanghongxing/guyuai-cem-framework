package com.guyuai.module.system.framework.web.config;

import com.guyuai.framework.swagger.config.GuyuaiSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的 web 组件的 Configuration
 *
 * @author 谷雨源码
 */
@Configuration(proxyBeanMethods = false)
public class SystemWebConfiguration {

    /**
     * system 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi systemGroupedOpenApi() {
        return GuyuaiSwaggerAutoConfiguration.buildGroupedOpenApi("system");
    }

}
