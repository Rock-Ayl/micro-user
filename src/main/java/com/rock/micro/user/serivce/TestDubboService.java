package com.rock.micro.user.serivce;

/**
 * 测试远程调用服务
 *
 * @Author ayl
 * @Date 2025-03-19
 */
public interface TestDubboService {

    /**
     * 测试
     *
     * @return
     */
    String helloWorld();

    /**
     * 测试2
     *
     * @param word
     * @return
     */
    String helloWorld2(String word);

}