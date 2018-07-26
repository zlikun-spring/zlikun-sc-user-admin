package com.zlikun.sc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/26 14:46
 */
@Configuration
public class RestConfiguration {

    /**
     * 配置 RestTemplate，并配置 LoadBalanced
     * http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__spring_cloud_commons_common_abstractions.html#_spring_resttemplate_as_a_load_balancer_client
     * http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__spring_cloud_commons_common_abstractions.html#_spring_webclient_as_a_load_balancer_client
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate loadBalanced() {
        return new RestTemplate();
    }

    /**
     * 配置多个 RestTemplate 实例
     * http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__spring_cloud_commons_common_abstractions.html#_multiple_resttemplate_objects
     * @return
     */
    @Primary
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
