package com.common;

import com.bean.PersonBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DataUtils
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/4 16:03
 */
public class DataUtils {

    public static Map getData() {
        Map map = new HashMap();
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

        map.put(ConstantUtils.PEOPLE,people);
        map.put(ConstantUtils.PERSON,person);
        return map;
    }
}
