package com.rock.micro.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rock.micro.base.data.BaseDO;
import com.rock.micro.user.mapper.UserMapper;
import com.rock.micro.user.pojo.mdo.UserDO;
import com.rock.micro.user.serivce.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

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
    public String loginByEmail(LoginParam loginParam) {
        return null;
    }

}