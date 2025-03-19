package com.rock.micro.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rock.micro.user.pojo.mdo.TestDO;

import java.util.List;
import java.util.Map;

/**
 * 测试 mapper
 *
 * @Author ayl
 * @Date 2022-03-13
 */
public interface TestMapper extends BaseMapper<TestDO> {

    /**
     * 条件查询demo
     *
     * @param params
     * @return
     */
    List<TestDO> selectByCondition(Map<String, Object> params);

}