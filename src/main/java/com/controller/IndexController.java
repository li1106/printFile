package com.controller;

import com.bean.PersonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IndexControlelr
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/3 17:35
 */
@Controller
@RequestMapping({"index","/"})
@Slf4j
public class IndexController {
    @RequestMapping(value = {"index","/"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model) {
//        log.info("IndexController.index param:{}",model.);
        PersonBean person = new PersonBean();
        person.setName("张三");
        person.setAge(22);

        List<PersonBean> people = new ArrayList<>();
        PersonBean p1 = new PersonBean();
        p1.setName("李四");
        p1.setAge(23);
        people.add(p1);

        PersonBean p2 = new PersonBean();
        p2.setName("王五");
        p2.setAge(24);
        people.add(p2);

        PersonBean p3 = new PersonBean();
        p3.setName("赵六");
        p3.setAge(25);
        people.add(p3);

        model.addAttribute("person", person);
        model.addAttribute("people", people);

        return "index";
    }
}
