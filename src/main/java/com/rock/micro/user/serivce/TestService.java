package com.rock.micro.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rock.micro.user.pojo.mdo.TestDO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    /**
     * 语句查询demo
     *
     * @param params 参数
     * @return
     */
    List<TestDO> selectByCondition(Map<String, Object> params);

}