package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName PoolConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/4 15:25
 */
@Configuration
public class PoolConfig {
    @Value("${pool.corePoolSize}")
    private Integer corePoolSize;
    @Value("${pool.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${pool.queueCapacity}")
    private Integer queueCapacity;
    @Value("${pool.keepAliveSeconds}")
    private Integer keepAliveSeconds;
    @Value("${pool.threadNamePrefix}")
    private String threadNamePrefix;


    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
