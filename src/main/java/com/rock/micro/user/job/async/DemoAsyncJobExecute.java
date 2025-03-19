package com.rock.micro.user.job.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 异步定时任务实现
 *
 * @Author ayl
 * @Date 2022-03-16
 */
@Service
public class DemoAsyncJobExecute {

    private static final Logger logger = LoggerFactory.getLogger(DemoAsyncJobExecute.class);

    //异步任务实现,需要指定对应bean
    @Async(AsyncJobThreadPoolTaskConfig.SYNC_TASK_POOL_EXECUTOR)
    public void asyncExecute() {
        logger.info("异步任务随机数:[{}]", new Random().nextInt(100));
    }

}