package com.guyuai.framework.idempotent.config;

import com.guyuai.framework.idempotent.core.aop.IdempotentAspect;
import com.guyuai.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.guyuai.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.guyuai.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.guyuai.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import com.guyuai.framework.redis.config.GuyuaiRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = GuyuaiRedisAutoConfiguration.class)
public class GuyuaiIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
