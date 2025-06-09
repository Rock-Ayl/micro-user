package com.rock.micro.user.db;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rock.micro.base.data.BaseDO;
import com.rock.micro.base.util.FastJsonExtraUtils;
import com.rock.micro.user.pojo.mdo.TestDO;
import com.rock.micro.user.serivce.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TestMysql {

    @Autowired
    private TestService testService;

    @Test
    void create() {

        List<TestDO> list = new ArrayList<>();
        TestDO one = new TestDO();
        TestDO two = new TestDO();
        one.setEmail("789测试");
        two.setEmail("11111测试");
        list.add(one);
        list.add(two);
        testService.create(list);
        System.out.println();
    }

    @Test
    void sqlQuery() {
        //查询条件
        Map<String, Object> params = new HashMap<>();
        //限制邮箱
        params.put("email", "11111测试");
        //查询
        List<TestDO> doList = testService.selectByCondition(params);
        System.out.println();
    }

    @Test
    void search() {
        //分页
        int pageNum = 1;
        int pageSize = 20;
        //初始化删除条件
        LambdaQueryWrapper<TestDO> queryWrapper = new LambdaQueryWrapper<>();
        //限制条件
        queryWrapper.eq(TestDO::getEmail, "test@qq.com");
        queryWrapper.eq(TestDO::getPwd, "123456");
        //排序
        queryWrapper.orderByDesc(TestDO::getCreateDate);
        //查询并返回
        Page<TestDO> pageResult = testService.page(new Page<>(pageNum, pageSize), queryWrapper);
        //输出
        FastJsonExtraUtils.toJSONString(pageResult);
    }

    @Test
    void updateSkipNull() {
        //初始化
        TestDO updateDo = new TestDO();
        //更新默认参数
        BaseDO.updateBuild(updateDo);
        //根据id更新
        updateDo.setId("123");
        //修改名称
        updateDo.setName("测试");
        //更新实现
        testService.updateById(updateDo);
    }

    @Test
    void updateSkipByWrapper() {

        //初始化
        TestDO updateDo = new TestDO();
        //更新默认参数
        BaseDO.updateBuild(updateDo);
        //修改名称
        updateDo.setName("测试");

        //初始化更新条件
        LambdaUpdateWrapper<TestDO> updateWrapper = new LambdaUpdateWrapper<>();
        //根据邮箱修改
        updateWrapper.eq(TestDO::getEmail, "test@qq.com");
        //更新实现
        testService.update(updateDo, updateWrapper);

    }

}
