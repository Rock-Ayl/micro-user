package com.rock.micro.user.db;

import com.rock.micro.user.pojo.mdo.UserDO;
import com.rock.micro.user.serivce.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestMysql {

    @Autowired
    private UserService userService;

    @Test
    void create() {

        List<UserDO> list = new ArrayList<>();
        UserDO one = new UserDO();
        UserDO two = new UserDO();
        one.setEmail("789测试");
        two.setEmail("11111测试");
        list.add(one);
        list.add(two);
        userService.create(list);
        System.out.println();
    }

    @Test
    void search() {

        //todo
    }

    @Test
    void updateSkipNull() {
        //todo
    }

    @Test
    void updateSkipByWrapper() {
        //todo
    }

}
