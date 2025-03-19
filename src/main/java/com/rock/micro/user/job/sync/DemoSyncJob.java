package com.rock.micro.user.job.sync;

import com.rock.micro.user.job.async.demo.DemoAsyncJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 同步定时任务模板
 * 注：默认情况下，所有{@link Scheduled} 注解，只会由一个线程去执行。
 * 所以如果某个定时任务执行时间太久，不要用这个方式实现，而要用{@link DemoAsyncJob} 方式实现。
 *
 * @Author ayl
 * @Date 2022-03-09
 */
//todo 如果有需要,开启注解 @Component
public class DemoSyncJob {

    private static final Logger logger = LoggerFactory.getLogger(DemoSyncJob.class);

    /**
     * 每5秒执行一次,同步任务(所有同步任务共用一个线程,如果该任务效率很快建议同步)
     */
    @Scheduled(cron = "0/5 * *  * * ?")
    public void demo() {
        logger.info("五秒一次的输出:[{}]", System.currentTimeMillis());
    }

    /**
     * 每10秒执行一次,同步任务(所有同步任务共用一个线程,如果该任务效率很快建议同步)
     */
    @Scheduled(cron = "0/10 * *  * * ?")
    public void demo2() {
        logger.info("十秒一次的输出:[{}]", System.currentTimeMillis());
    }

}