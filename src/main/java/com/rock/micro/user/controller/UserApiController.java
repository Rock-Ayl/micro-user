package com.rock.micro.user.controller;

import com.rock.micro.base.common.auth.LoginAuth;
import com.rock.micro.base.data.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @Author ayl
 * @Date 2022-03-23
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/user")
public class UserApiController {

    @LoginAuth
    @ApiOperation(value = "测试接口")
    @GetMapping(value = "/test")
    public String test() {
        //尝试获取用户信息
        User user = LoginAuth.USER.get();
        //返回
        return "请求成功!";
    }

}
