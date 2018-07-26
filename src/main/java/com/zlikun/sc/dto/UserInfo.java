package com.zlikun.sc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/15 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long userId ;
    private String name ;
    private String mobile ;

}
