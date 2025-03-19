package com.rock.micro.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rock.micro.user.pojo.mdo.UserDO;

import java.util.Collection;

/**
 * 用户服务
 */
public interface UserService extends IService<UserDO> {

    /**
     * 批量创建用户
     *
     * @param doList 用户实体集合
     * @return
     */
    Collection<UserDO> create(Collection<UserDO> doList);

}