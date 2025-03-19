package com.rock.micro.user.job.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * 定时任务的线程池配置,所有异步的定时任务走这个bean
 * 默认情况下,在创建了线程池后,线程池中的线程数为0,当有任务来之后,就会创建一个线程去执行任务,
 * 当线程池中的线程数目达到corePoolSize后,就会把到达的任务放到缓存队列当中；
 * 当队列满了,就继续创建线程,当线程数量大于等于maxPoolSize后,开始使用拒绝策略拒绝
 *
 * @Author ayl
 * @Date 2022-03-14
 */
@Configuration
public class AsyncJobThreadPoolTaskConfig {

    //本配置的bean名名称
    public static final String SYNC_TASK_POOL_EXECUTOR = "syncTaskPoolExecutor";

    //bean的名称,默认为首字母小写的方法名
    @Bean(SYNC_TASK_POOL_EXECUTOR)
    public ThreadPoolTaskExecutor syncTaskPoolExecutor() {

        //Spring 线程池对象
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        /**
         * 基本配置
         */

        //获取处理器核心数
        int coreCount = Runtime.getRuntime().availableProcessors();

        //核心线程数(默认线程数)
        executor.setCorePoolSize(coreCount + 1);
        //最大线程数
        executor.setMaxPoolSize(coreCount * 4 + 1);
        //缓冲队列大小
        executor.setQueueCapacity(coreCount * 10);
        //允许线程空闲时间(单位:秒)
        executor.setKeepAliveSeconds(60);
        //线程池名前缀(日志打印)
        executor.setThreadNamePrefix("Async-Job-");

        /**
         * 其他配置
         */

        //线程池会等待所有任务执行完成后再关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //在强制关闭线程池时等待剩余任务完成的最长时间
        executor.setAwaitTerminationSeconds(60);

        //修改拒绝策略为使用当前线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        /**
         * 初始化
         */

        //初始化
        executor.initialize();
        return executor;
    }

}