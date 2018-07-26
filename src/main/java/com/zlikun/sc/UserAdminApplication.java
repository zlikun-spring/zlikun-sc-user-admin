package com.zlikun.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置注册中心
 * http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__spring_cloud_commons_common_abstractions.html#_serviceregistry
 */
// 启用服务发现客户端配置
// autoRegister = true 为默认值，通常不需要配置，等价：eureka.client.register-with-eureka: true
// 除非不注册到注册中心(本工程不对外提供服务，原则上可以不注册)
@EnableDiscoveryClient
@SpringBootApplication
public class UserAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);
    }

}
