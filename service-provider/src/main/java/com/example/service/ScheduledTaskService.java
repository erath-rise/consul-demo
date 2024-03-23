package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTaskService {
    @Scheduled(fixedRate = 5000) // 每5秒执行一次
    public void executeTask() {
        System.out.println("执行定时任务: " + System.currentTimeMillis());
    }
}

