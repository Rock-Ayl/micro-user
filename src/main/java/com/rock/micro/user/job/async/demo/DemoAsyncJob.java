package com.rock.micro.user.job.async.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 异步定时任务模板
 *
 * @Author ayl
 * @Date 2022-03-16
 */
//todo 如果有需要,开启注解 @Component
public class DemoAsyncJob {

    @Autowired
    private DemoAsyncJobExecute demoAsyncExecute;

    /**
     * 每5秒执行一次,异步任务(异步任务单独使用一个线程,只有速度很慢的建议如此)
     */
    @Scheduled(cron = "0/5 * *  * * ?")
    public void demo3() {
        //异步实现,执行的异步方法,异步方法和当前调用的方法不能在同一个类中,否则无法实现异步,官方文档有说明.
        demoAsyncExecute.asyncExecute();
    }

}