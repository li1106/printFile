package com.controller;

import com.bean.PersonBean;
import com.common.ConstantUtils;
import com.common.DataUtils;
import com.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.System.*;

/**
 * @ClassName IndexControlelr
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/3 17:35
 */
@Controller
@RequestMapping({"/"})
//@RequestMapping({"index","/"})
@Slf4j
@Api(description = "程序入口接口")
public class IndexController {
    @Autowired
    private IndexService indexService;


    @ApiOperation(value = "跳转index首页接口", notes="跳转index首页接口")
    @ApiImplicitParam(name = "model", value = "Model对象", paramType = "saveData", required = false, dataType = "Model")
    @RequestMapping(value = {"index"}, method = {RequestMethod.GET})
//    @RequestMapping(value = {"index"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model) throws ExecutionException, InterruptedException {
        Map data = DataUtils.getData();

        List<PersonBean> people = (List<PersonBean>) data.get(ConstantUtils.PEOPLE);
        PersonBean person = (PersonBean) data.get(ConstantUtils.PERSON);

        Future<List<PersonBean>> listFuture = indexService.asyncIndexTask1(people);
        Future<PersonBean> personBeanFuture = indexService.asyncIndexTask2(person);

        log.info("indexService.asyncIndexTask1 result:{}",listFuture.get());
        log.info("indexService.asyncIndexTask2 result:{}",personBeanFuture.get());

        model.addAttribute("person", person);
        model.addAttribute("people", people);

        return "index";
    }
}
