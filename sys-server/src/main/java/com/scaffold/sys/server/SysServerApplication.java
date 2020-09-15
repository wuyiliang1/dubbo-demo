package com.scaffold.sys.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuyiliang
 * @date 2020/9/11 14:26
 */
@EnableDubbo(scanBasePackages = {"com.scaffold.sys.server.provider"})
@SpringBootApplication(scanBasePackages = {"com.scaffold.sys.server", "cn.hutool.extra.spring"})
public class SysServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysServerApplication.class, args);
    }
}
