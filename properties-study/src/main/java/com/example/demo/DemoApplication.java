package com.example.demo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.example.demo.config.DubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 创建配置上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前配置 Bean
        context.register(DubboConfiguration.class);
        context.refresh();
        // 获取 ApplicationConfig Bean："applicationBean"、"applicationBean2" 和 "applicationBean3"
        ApplicationConfig applicationBean = context.getBean("applicationBean", ApplicationConfig.class);
        ApplicationConfig applicationBean2 = context.getBean("applicationBean2", ApplicationConfig.class);
        ApplicationConfig applicationBean3 = context.getBean("applicationBean3", ApplicationConfig.class);

        System.out.printf("applicationBean.name = %s \n", applicationBean.getName());
        System.out.printf("applicationBean2.name = %s \n", applicationBean2.getName());
        System.out.printf("applicationBean3.name = %s \n", applicationBean3.getName());

        // 获取 ModuleConfig Bean："moduleBean"
        ModuleConfig moduleBean = context.getBean("moduleBean", ModuleConfig.class);

        System.out.printf("moduleBean.name = %s \n", moduleBean.getName());

        // 获取 RegistryConfig Bean
        RegistryConfig registry = context.getBean(RegistryConfig.class);

        System.out.printf("registry.address = %s \n", registry.getAddress());
    }



}
