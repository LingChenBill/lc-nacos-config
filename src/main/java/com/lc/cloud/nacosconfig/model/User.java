package com.lc.cloud.nacosconfig.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 用户.
 * @description: 绑定配置文件中的user info,实现动态刷新.
 *    @Configuration @Value 与 @RefreshScope一起使用.
 *    @ConfigurationProperties(prefix = "user") 与 @RefreshScope一起使用(@Value可以不用).
 *      此时,启动类上要加上 @EnableConfigurationProperties(User.class)
 * @author: lingchen
 * @date: 2020/12/13
 */
//@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "user")
@Data
@Slf4j
public class User {

//    @Value("${user.name}")
    private String name;

//    @Value("${user.age}")
    private int age;

    @PostConstruct
    public void init() {
        log.info(String.format("[init] user name: %s, age: %d%n", this.name, this.age));
    }

    @PreDestroy
    public void destory() {
        log.info(String.format("[destory] user name: %s, age: %d%n", this.name, this.age));
    }

}
