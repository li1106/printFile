package com.service;

import com.bean.PersonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @ClassName IndexServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/4 15:31
 */
@Slf4j
@Service
public class IndexServiceImpl implements IndexService {
    @Override
    @Async("taskExecutor")
    public Future<List<PersonBean>> asyncIndexTask1(List<PersonBean> people) {
        log.info("IndexServiceImpl --asyncIndexTask threadName:{}",Thread.currentThread().getName());
        return  new AsyncResult<>(people);
    }

    @Override
    @Async
    public Future<PersonBean> asyncIndexTask2(PersonBean people) {
        log.info("IndexServiceImpl --asyncIndexTask threadName:{}",Thread.currentThread().getName());
        return  new AsyncResult<>(people);
    }
}
