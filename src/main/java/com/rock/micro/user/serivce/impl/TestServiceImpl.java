package com.rock.micro.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rock.micro.base.data.BaseDO;
import com.rock.micro.user.mapper.TestMapper;
import com.rock.micro.user.pojo.mdo.TestDO;
import com.rock.micro.user.serivce.TestService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestDO> implements TestService {

    @Override
    public Collection<TestDO> create(Collection<TestDO> doList) {
        //判空
        if (CollectionUtils.isEmpty(doList)) {
            //过
            return new ArrayList<>();
        }
        //循环
        for (TestDO testDO : doList) {
            //初始化创建
            BaseDO.createBuild(testDO);
        }
        //实现
        this.saveBatch(doList);
        //返回
        return doList;
    }

}