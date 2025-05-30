package com.rock.micro.user.controller;

import com.rock.micro.base.common.api.JSONResponse;
import com.rock.micro.base.common.api.MyException;
import com.rock.micro.base.common.auth.LoginAuth;
import com.rock.micro.base.common.constant.HttpConst;
import com.rock.micro.base.data.User;
import com.rock.micro.user.serivce.TestDubboService;
import com.rock.micro.user.serivce.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制层
 *
 * @Author ayl
 * @Date 2022-03-23
 */
@Api(tags = "测试模块")
@RestController
@RequestMapping(value = "/test")
public class TestApiController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestDubboService testDubboService;

    @LoginAuth
    @ApiOperation(value = "测试接口")
    @GetMapping(value = "/test", produces = HttpConst.RESPONSE_HEADERS_CONTENT_TYPE_APPLICATION_JSON)
    public String test() {
        //尝试获取用户信息
        User user = LoginAuth.USER.get();
        //测试
        if (true) {
            //抛出
            throw new MyException("测试");
        }
        //返回结果
        return JSONResponse.success().putResult(user).toString();
    }

    @LoginAuth
    @ApiOperation(value = "测试远程调用")
    @GetMapping(value = "/commonDubbo", produces = HttpConst.RESPONSE_HEADERS_CONTENT_TYPE_APPLICATION_JSON)
    public String commonDubbo(String word) {
        //远程调用结果
        String result;
        try {

            /**
             * 必须在外层tryCatch抛出,否则无法走统一抛出异常实现
             */

            //远程调用实现
            result = testDubboService.helloWorld2(word);
        } catch (Exception e) {
            throw e;
        }
        //返回结果
        return JSONResponse.success().put("result", result).toString();
    }

}
