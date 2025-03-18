package com.rock.micro.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @Author ayl
 * @Date 2022-03-23
 */
@RestController
@RequestMapping(value = "/user")
public class UserApiController {

    @GetMapping(value = "/test")
    public String test() {
        return "请求成功!";
    }

}
