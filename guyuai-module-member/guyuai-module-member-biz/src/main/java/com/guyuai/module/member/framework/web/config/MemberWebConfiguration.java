package com.guyuai.module.member.framework.web.config;

import com.guyuai.framework.swagger.config.GuyuaiSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * member 模块的 web 组件的 Configuration
 *
 * @author 谷雨源码
 */
@Configuration(proxyBeanMethods = false)
public class MemberWebConfiguration {

    /**
     * member 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi memberGroupedOpenApi() {
        return GuyuaiSwaggerAutoConfiguration.buildGroupedOpenApi("member");
    }

}
