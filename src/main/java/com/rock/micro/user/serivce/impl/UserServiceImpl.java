package com.rock.micro.user.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rock.micro.base.common.constant.RedisKey;
import com.rock.micro.base.data.BaseDO;
import com.rock.micro.base.db.redis.BaseRedisService;
import com.rock.micro.base.util.FastJsonExtraUtils;
import com.rock.micro.base.util.UserExtraUtils;
import com.rock.micro.user.mapper.UserMapper;
import com.rock.micro.user.pojo.mdo.UserDO;
import com.rock.micro.user.serivce.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private BaseRedisService baseRedisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO create(UserDO userDO) {
        //初始化创建
        BaseDO.createBuild(userDO);
        //插入
        this.save(userDO);
        //返回
        return userDO;
    }

    @Override
    public Collection<UserDO> create(Collection<UserDO> doList) {
        //判空
        if (CollectionUtils.isEmpty(doList)) {
            //过
            return new ArrayList<>();
        }
        //循环
        for (UserDO userDO : doList) {
            //初始化创建
            BaseDO.createBuild(userDO);
        }
        //实现
        this.saveBatch(doList);
        //返回
        return doList;
    }

    @Override
    public UserDO getByEmail(String email) {
        //判空
        if (StringUtils.isBlank(email)) {
            //过
            return null;
        }
        //初始化查询
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        //限制手机号
        query.eq("email", email);
        //查询并返回
        return userMapper.selectOne(query);
    }

    @Override
    public String loginByEmail(LoginParam loginParam) {
        //获取邮箱、密码
        String email = Optional.ofNullable(loginParam)
                .map(LoginParam::getEmail)
                .orElse("");
        String pwd = Optional.ofNullable(loginParam)
                .map(LoginParam::getPwd)
                .orElse("");
        //判空
        if (StringUtils.isAnyBlank(email, pwd)) {
            //过
            return null;
        }
        //查询是否存在当前账号
        UserDO userDO = getByEmail(email);
        //判空
        if (userDO == null) {
            //过
            return null;
        }
        //获取账号密码
        String userPwd = userDO.getPwd();
        //如果密码错误
        if (pwd.equals(userPwd) == false) {
            //过
            return null;
        }
        //用户id
        String userId = userDO.getId();
        //生成对用token
        String token = UserExtraUtils.creatUserToken(userId);
        //用户实体脱敏
        desensitization(userDO);
        //写入缓存,有效期1天
        baseRedisService.setAndTime(RedisKey.USER_LOGIN_AUTH_SET + token, FastJsonExtraUtils.toJSONString(userDO), 3600 * 24);
        //返回
        return token;
    }

    @Override
    public void desensitization(UserDO user) {
        //判空
        if (user == null) {
            //过
            return;
        }
        //脱密
        user.setPwd(null);
    }

}