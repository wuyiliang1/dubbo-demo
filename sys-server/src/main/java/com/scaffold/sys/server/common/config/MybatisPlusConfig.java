package com.scaffold.sys.server.common.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author wuyiliang
 * @date 2020/9/14 10:03
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 配置分页
     */
    @Bean
    @Order(0)
    public PaginationInnerInterceptor paginationInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
