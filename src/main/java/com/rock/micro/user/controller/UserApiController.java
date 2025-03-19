package com.rock.micro.user.controller;

import com.rock.micro.base.common.api.JSONResponse;
import com.rock.micro.base.common.constant.HttpConst;
import com.rock.micro.user.pojo.mdo.UserDO;
import com.rock.micro.user.serivce.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private UserService userService;

    @ApiOperation(value = "邮箱登录")
    @PostMapping(value = "/loginByEmail", produces = HttpConst.RESPONSE_HEADERS_CONTENT_TYPE_APPLICATION_JSON)
    public String loginByEmail(@RequestBody UserService.LoginParam loginParam) {
        //实现并返回token
        String token = userService.loginByEmail(loginParam);
        //返回
        return JSONResponse.success().putResult(token).toString();
    }

    @ApiOperation(value = "注册新用户")
    @PostMapping(value = "/addUser", produces = HttpConst.RESPONSE_HEADERS_CONTENT_TYPE_APPLICATION_JSON)
    public String addUser(@RequestBody UserDO userDO) {
        //todo
        //返回
        return JSONResponse.success().putResult(null).toString();
    }

}