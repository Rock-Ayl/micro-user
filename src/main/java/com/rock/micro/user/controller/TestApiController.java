package com.rock.micro.user.controller;

import com.rock.micro.base.common.api.JSONResponse;
import com.rock.micro.base.common.auth.LoginAuth;
import com.rock.micro.base.data.User;
import com.rock.micro.user.pojo.mdo.TestDO;
import com.rock.micro.user.serivce.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @LoginAuth
    @ApiOperation(value = "测试接口")
    @GetMapping(value = "/test")
    public String test() {
        //尝试获取用户信息
        User user = LoginAuth.USER.get();
        //查询条件
        Map<String, Object> params = new HashMap<>();
        //限制邮箱
        params.put("email", "11111测试");
        //查询
        List<TestDO> doList = testService.selectByCondition(params);
        //返回结果
        return JSONResponse.success().put("result", doList).put("user", user).toString();
    }

}
