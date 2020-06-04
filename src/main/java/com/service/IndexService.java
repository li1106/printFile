package com.service;

import com.bean.PersonBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

public interface IndexService {

    Future<List<PersonBean>> asyncIndexTask1(List<PersonBean> people);

    Future<PersonBean> asyncIndexTask2(PersonBean people);
}
