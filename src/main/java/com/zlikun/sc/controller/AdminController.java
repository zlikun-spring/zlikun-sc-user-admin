package com.zlikun.sc.controller;

import com.zlikun.sc.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 模拟一个数据接口
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/15 14:13
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("loadBalanced")
    private RestTemplate loadBalanced;

    final String USER_SERVICE_ID = "USER";

    /**
     * http://localhost:9010/admin/user/10086
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public Object get(@PathVariable long userId) {
        log.info("调用用户微服务获取用户数据");
        return loadBalanced.getForObject(String.format("http://%s/user/{1}", USER_SERVICE_ID), UserInfo.class, userId);
    }

}
