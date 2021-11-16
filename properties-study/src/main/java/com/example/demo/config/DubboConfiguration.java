package com.example.demo.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfigBinding;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfigBindings;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * DubboConfiguration
 *
 * @author jiankang.xu
 * @date 2021/11/6
 */
@EnableDubboConfigBindings({
        @EnableDubboConfigBinding(prefix = "${applications.prefix}",
                type = ApplicationConfig.class, multiple = true), // 多 ApplicationConfig Bean 绑定
        @EnableDubboConfigBinding(prefix = "dubbo.module", // 不带 "." 后缀
                type = ModuleConfig.class), // 单 ModuleConfig Bean 绑定
        @EnableDubboConfigBinding(prefix = "dubbo.registry.", // 带 "." 后缀
                type = RegistryConfig.class) // 单 RegistryConfig Bean 绑定
})
@PropertySource("META-INF/bindings.properties")
@Configuration
public class DubboConfiguration {

    public static void main(String[] args) {

    }

}