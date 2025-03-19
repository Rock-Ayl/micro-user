package com.rock.micro.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rock.micro.user.pojo.mdo.TestDO;

import java.util.Collection;

/**
 * 测试服务
 */
public interface TestService extends IService<TestDO> {

    /**
     * 批量创建
     *
     * @param doList 实体集合
     * @return
     */
    Collection<TestDO> create(Collection<TestDO> doList);

}