package com.rock.micro.user.db;

import com.rock.micro.base.db.redis.BaseRedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestRedis {

    @Autowired
    private BaseRedisService baseRedisService;

    @Test
    void test() {

        String key2 = "rock@4444";
        long count = baseRedisService.incr(key2, 1);
        System.out.println(123);
        long count2 = baseRedisService.incr(key2, 2);
        System.out.println(123);
    }

    @Test
    void testLock() {
        String key2 = "rock@test_lock_one";
        boolean lock = baseRedisService.lock(key2, 13000);
        System.out.println(lock);
    }

}
