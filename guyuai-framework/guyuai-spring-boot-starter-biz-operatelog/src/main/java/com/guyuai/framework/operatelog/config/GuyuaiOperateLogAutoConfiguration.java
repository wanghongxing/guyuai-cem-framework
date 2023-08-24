package com.guyuai.framework.operatelog.config;

import com.guyuai.framework.operatelog.core.aop.OperateLogAspect;
import com.guyuai.framework.operatelog.core.service.OperateLogFrameworkService;
import com.guyuai.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.guyuai.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class GuyuaiOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
