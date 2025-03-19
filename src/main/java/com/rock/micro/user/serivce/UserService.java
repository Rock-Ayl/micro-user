package com.rock.micro.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rock.micro.user.pojo.mdo.UserDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * 用户服务
 */
public interface UserService extends IService<UserDO> {

    /**
     * 创建用户
     *
     * @param userDO 用户实体
     * @return
     */
    UserDO create(UserDO userDO);

    /**
     * 批量创建用户
     *
     * @param doList 用户实体集合
     * @return
     */
    Collection<UserDO> create(Collection<UserDO> doList);

    /**
     * 根据邮箱,获取用户信息
     *
     * @param email 邮箱
     * @return
     */
    UserDO getByEmail(String email);

    /**
     * 用户信息脱敏
     *
     * @param user
     */
    void desensitization(UserDO user);

    /**
     * 邮箱登录参数
     */
    @Setter
    @Getter
    public static class LoginParam {

        @ApiModelProperty("邮箱")
        private String email;

        @ApiModelProperty("密码")
        private String pwd;

    }

    /**
     * 根据邮箱,登录并返回token
     *
     * @param loginParam
     * @return
     */
    String loginByEmail(LoginParam loginParam);

}