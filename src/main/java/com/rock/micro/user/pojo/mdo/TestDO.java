package com.rock.micro.user.pojo.mdo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rock.micro.base.data.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 测试实体
 *
 * @Author ayl
 * @Date 2022-03-13
 */
@Getter
@Setter
@ApiModel("测试实体")
@TableName("micro_user_test")
public class TestDO extends BaseDO {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("用户备注")
    private String remark;

}