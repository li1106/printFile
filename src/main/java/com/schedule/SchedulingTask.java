package com.schedule;

import com.controller.IndexController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduleConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/4 15:03
 */
@Component
@Slf4j
public class SchedulingTask {
    private final IndexController indexController;

    @Autowired
    public SchedulingTask(IndexController indexController) {
        this.indexController = indexController;
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void task1() {
//        indexController.index()
        log.info("SchedulingTask.task1----->");
    }
}
