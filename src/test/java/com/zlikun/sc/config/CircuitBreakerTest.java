package com.zlikun.sc.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * 断路器(熔断)测试
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/27 18:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CircuitBreakerTest {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private final String USER_SERVICE_ID = "user";

    @Test
    public void search() {

        ResponseEntity<List> entity = restTemplate.getForEntity(String.format("http://%s/user/search", USER_SERVICE_ID),
                List.class);
        assertTrue(entity.getStatusCode().is2xxSuccessful());


    }

}
