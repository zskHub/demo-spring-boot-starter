package com.zsk.starter.config;

import com.zsk.starter.properties.DemoProperties;
import com.zsk.starter.service.DemoService;
import com.zsk.starter.service.impl.DemoServiceImplA;
import com.zsk.starter.service.impl.DemoServiceImplB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : zsk
 * @CreateTime : 2021-09-14   11:53
 */
/**
 * ConditionalOnProperty注解
 * prefix:配置文件的前缀
 * name：配置的名字
 * havingValue：与配置的值对比，当两个值相同返回true时，配置类生效
 * 如果返回值为false，则该configuration不生效；为true则生效
 * matchIfMissing = true表示如果没有在application.properties设置该属性，则默认为条件符合
 * */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = DemoProperties.DEMO_PREFIX,
        name = "isOpen",
        havingValue = "true",
        matchIfMissing = true
)
//可以支持表达式，这里为了举例子，用了equals方法和直接冒号后面加上true的方法。
//@ConditionalOnExpression("'${" + DemoProperties.DEMO_PREFIX + ".isOpen}'.equals('true') && ${"+DemoProperties.DEMO_PREFIX+".isOpen:true}")
public class DemoConfig {
    /**
     * ConditionalOnMissingBean
     * 它是修饰bean的一个注解，
     * 主要实现的是，当你的bean被注册之后，如果而注册相同类型的bean，就不会成功，
     * 它会保证你的bean只有一个，即你的实例只有一个，
     * 当你注册多个相同的bean时，会出现异常，以此来告诉开发人员。
     * */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(
            prefix = DemoProperties.DEMO_PREFIX,
            name = "implType",
            havingValue = "A",
            matchIfMissing = true
    )
    public DemoService getDemoServiceA() {
        return new DemoServiceImplA();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(
            prefix = "demo",
            name = "implType",
            havingValue = "B"
    )
    public DemoService getDemoServiceB() {
        return new DemoServiceImplB();
    }
}
