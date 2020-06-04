package com.schedule;

import com.bean.PersonBean;
import com.common.ConstantUtils;
import com.common.DataUtils;
import com.controller.IndexController;
import com.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName ScheduleConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/4 15:03
 */
@Component
@Slf4j
public class SchedulingTask {
    @Autowired
    private IndexService indexService;

    @Scheduled(cron = "*/1 * * * * ?")
    public void task1() throws ExecutionException, InterruptedException {
        Map data = DataUtils.getData();
        List<PersonBean> people = (List<PersonBean>) data.get(ConstantUtils.PEOPLE);
        PersonBean person = (PersonBean) data.get(ConstantUtils.PERSON);
        Future<List<PersonBean>> listFuture = indexService.asyncIndexTask1(people);
        Future<PersonBean> personBeanFuture = indexService.asyncIndexTask2(person);
//        log.debug("SchedulingTask.task1.asyncIndexTask1 result:{},SchedulingTask.task1.asyncIndexTask2 result:{}",listFuture.get(),personBeanFuture.get());
        log.warn("SchedulingTask.task1.asyncIndexTask1 result:{},SchedulingTask.task1.asyncIndexTask2 result:{}",listFuture.get(),personBeanFuture.get());
    }
}
