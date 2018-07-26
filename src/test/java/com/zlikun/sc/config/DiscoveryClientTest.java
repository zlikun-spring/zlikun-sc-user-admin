package com.zlikun.sc.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/26 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscoveryClientTest {

    @Autowired
    private DiscoveryClient client;

    @Test
    public void test() {

        // 查看用户服务数据
        // {management.port=9000, jmx.port=51442}
        for (ServiceInstance instance : client.getInstances("user")) {
            System.out.println(instance.getMetadata());
        }

    }

}
