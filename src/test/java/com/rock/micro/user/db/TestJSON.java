package com.rock.micro.user.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rock.micro.base.util.FastJsonExtraUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author ayl
 * @Date 2024-10-21
 */
public class TestJSON {

    /**
     * Jackson 序列化、序列化设置
     * 1. ignoreUnknown = true：反序列化过程中，忽略JSON中存在但Java类中不存在的属性
     * 2. value = {"abc"}：序列化、反序列化过程中，忽略名为"owd"的属性
     */
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"pwd"})
    @Setter
    @Getter
    private static class TestParam {

        @ApiModelProperty("手机号")
        private String phone;

        @ApiModelProperty("密码")
        private String pwd;

        @ApiModelProperty("abc")
        private String abc;

        @ApiModelProperty("测试3")
        private String test;

    }

    public static void main(String[] args) {

        //初始化
        TestParam param = new TestParam();
        //设置参数
        param.setAbc("abc");
        param.setTest("测试");
        param.setPwd("我是密码");
        param.setPhone("15591391203");

        //序列化
        String str = FastJsonExtraUtils.toJSONString(param);
        System.out.println(str);

        //反序列化
        TestParam newObject = FastJsonExtraUtils.deepClone(str, TestParam.class);
        System.out.println();

    }

}
