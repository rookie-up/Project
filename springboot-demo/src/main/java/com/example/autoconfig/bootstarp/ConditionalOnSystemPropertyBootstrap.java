package com.example.autoconfig.bootstarp;

import com.example.autoconfig.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link ConditionalOnSystemProperty}
 *
 * @author zhengyumin
 * @create 2019-01-04 8:35 PM
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "zhengyumin")
    public String helloWorld() {
        return "Hello,World 2019";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        // 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        System.err.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
