/**
 * Copyright (C), 2015-2017, tsfa
 * FileName: ThreadPoolConfig.java
 * Author:   chin
 * Date:     2018/8/17    下午2:32
 * Description:
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名     修改时间      版本号        描述
 */
package com.springboot.threadpool.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置<br>
 * 〈功能详细描述〉
 *
 * @author Chin
 * @since 1.0
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {


    @Value("${spring.threadpool.corePoolSize}")
    private String corePoolSize;

    @Value("${spring.threadpool.maxPoolSize}")
    private String maxPoolSize;

    @Value("${spring.threadpool.queueCapacity}")
    private String queueCapacity;

    @Value("${spring.threadpool.keepAliveSeconds}")
    private String keepAliveSeconds;

    @Value("${spring.threadpool.threadNamePrefix}")
    private String threadNamePrefix;


    @Bean("taskExecutor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(Integer.valueOf(corePoolSize));
        //最大线程数
        executor.setMaxPoolSize(Integer.valueOf(maxPoolSize));
        //缓冲队列允许的线程数
        executor.setQueueCapacity(Integer.valueOf(queueCapacity));
        //允许的线程空闲时间
        executor.setKeepAliveSeconds(Integer.valueOf(keepAliveSeconds));
        //线程前缀名
        executor.setThreadNamePrefix(threadNamePrefix);
        //排斥线程处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;

    }
}
