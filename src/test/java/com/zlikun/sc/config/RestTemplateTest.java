package com.zlikun.sc.config;

import com.zlikun.sc.dto.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/26 14:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    /**
     * 使用 RestTemplate 时，如果通过注册中心服务名调用服务，需要配置 @LoadBalanced
     * 可以在配置 RestTemplate Bean时指定，或者在使用时指定
     */
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    final String USER_SERVICE_ID = "user";

    @Test
    public void test() {

        UserInfo info = restTemplate.getForObject(String.format("http://%s/user/{1}", USER_SERVICE_ID), UserInfo.class, 10086);
        System.out.println(info);

    }

}
