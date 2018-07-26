package com.zlikun.sc.config;

import com.zlikun.sc.dto.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void getForObject() {
        // 返回一个POJO
        UserInfo info = restTemplate.getForObject(String.format("http://%s/user/{1}", USER_SERVICE_ID),
                UserInfo.class, 10086);
        System.out.println(info);

    }

    @Test
    public void getForEntity() {
        // 返回一个ResponseEntity<>对象
        ResponseEntity<UserInfo> entity = restTemplate.getForEntity(String.format("http://%s/user/{1}", USER_SERVICE_ID),
                UserInfo.class, 10086);
        // 获取响应状态码
        assertTrue(entity.getStatusCode().is2xxSuccessful());
        assertEquals(200, entity.getStatusCodeValue());
        // 获取响应消息体
        UserInfo info = entity.getBody();
        System.out.println(info);
        // 获取全部响应消息头
        for (Map.Entry<String, List<String>> entry : entity.getHeaders().entrySet()) {
            System.out.printf("%s:%s%n", entry.getKey(), entry.getValue());
        }

    }

    @Test
    public void post() {
        UserInfo user = new UserInfo();
        user.setName("Jane");
        ResponseEntity<Long> entity = restTemplate.postForEntity(String.format("http://%s/user/", USER_SERVICE_ID),
                user, Long.class);
        assertEquals(Long.valueOf(10000L), entity.getBody());
    }

    @Test
    public void put() {
        UserInfo user = new UserInfo();
        user.setName("Jane");
        restTemplate.put(String.format("http://%s/user/{1}", USER_SERVICE_ID), user, 10000L);
    }

    @Test
    public void delete() {
        restTemplate.delete(String.format("http://%s/user/{1}", USER_SERVICE_ID), 10000L);
    }

}
