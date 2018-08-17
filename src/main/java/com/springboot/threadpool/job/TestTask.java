/**
 * Copyright (C), 2015-2017, tsfa
 * FileName: TestTask.java
 * Author:   chin
 * Date:     2018/8/17    下午2:55
 * Description:
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名     修改时间      版本号        描述
 */
package com.springboot.threadpool.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试调度类<br>
 * 〈功能详细描述〉
 *
 * @author Chin
 * @since 1.0
 */
@Component
@EnableScheduling
public class TestTask {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestTask.class);

    @Scheduled(cron = "30 * * * * ?")
    @Async("taskExecutor")
    public void sendMsg() {
        //do something
        LOGGER.info("调用成功");
    }
}
