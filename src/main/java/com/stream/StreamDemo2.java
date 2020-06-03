package com.stream;

import com.common.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo2
 * @Description TODO 流编程[并行流 parallelStream()]
 * @Author Administrator
 * @Date 2020/6/3 11:21
 * 拓展:  strictfp, 即 strict float point (精确浮点)
 * 使用 strictfp 关键字声明一个方法时，该方法中所有的float和double表达式都严格遵守FP-strict的限制,
 * 符合IEEE-754规范。当对一个类或接口使用 strictfp 关键字时，该类中的所有代码，包括嵌套类型中的初
 * 始设定值和代码，都将严格地进行计算。严格约束意味着所有表达式的结果都必须是 IEEE 754 算法对操作
 * 数预期的结果，以单精度和双精度格式表示
 */
@Slf4j
public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(s -> s.isEmpty()).count();
        log.debug("空字符串数量:{}", count);


        log.info("------------->Collectors");
        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strs.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        log.debug("筛选列表: {}", filtered);
        /**
         * 拼接joining()
         */
        String mergedString = strs.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("..."));
        log.debug("合并字符串: {}", mergedString);

        log.info("--------------统计");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        /**
         *jdk1.8中，有summaryStatistics()流方法，我们可以根据此方法获取到集合中的最大值，最小值，和，平均值信息。
         */
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        log.debug("列表中最大的数 : {}", stats.getMax());
        log.debug("列表中最小的数 : {}", stats.getMin());
        log.debug("所有数之和 : {}", stats.getSum());
        log.debug("平均数 : {}", stats.getAverage());

        log.info("------------Stream.of() flatMap()");
        List<Integer> collected0 = new ArrayList<>();
        collected0.add(1);
        collected0.add(3);
        collected0.add(5);
        List<Integer> collected1 = new ArrayList<>();
        collected1.add(2);
        collected1.add(4);
        /**
         * of方法，其生成的Stream是有限长度的，Stream的长度为其内的元素个数 生成流
         * flatMap 合并 flatMap可以一下子合并多个集合，并且，不会正真意义上new出新的集合出来
         */
        collected1 = Stream.of(collected0, collected1)
                .flatMap(num -> num.stream()).collect(Collectors.toList());
        log.debug("合并结果:{}", collected1);// 1,3,5,2,4

        log.info("------------->reduce");
//        int sumAll = Stream.of(1, 2, 3, 4).reduce(0,
//                (sum, element) -> sum + element);// 给一个0是用来启动的，若给-1，结果会是9
        int sumAll = Stream.of(1, 2, 3, 4).reduce(0,
                Integer::sum);//  Integer在Java8中提供了sum求和静态方法

        log.debug("结果为:{}", sumAll);// 10

//        System.err.println(Collectors.toCollection(LinkedList::new).toString());

        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected.add("cool");
        collected.add("delta");
        collected.stream().map(string -> string.toUpperCase())
                .count();
        System.out.println(collected); // [alpha, beta, cool, delta]


        List<Person> personList = new ArrayList<>();//随机生成5个person实例
        for (int i = 0; i < 5; i++) {
            personList.add(new Person(i));
        }
        List<Integer> ages = new ArrayList<>();
        personList.stream().forEach(person -> ages.add(person.getAge()));
        System.out.println(ages);//第一处打印  [0, 1, 2, 3, 4]
        ages.clear();
        personList.stream().map(person -> {
            person.setAge(person.getAge() + 10);
            return person;
        }).count();
        personList.stream().forEach(person -> ages.add(person.getAge()));
        System.out.println(ages);//第二处打印  [10, 11, 12, 13, 14]

        /**
         * peek方法生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），
         * 新Stream每个元素被消费的时候都会执行给定的消费函数，并且消费函数优先执行
         */
        log.info("------------------->peek");
        Stream.of(1, 2, 3, 4, 5)
                .peek(integer -> System.out.println(integer))
                .forEach(System.out::println);

        /**
         * skip方法将过滤掉原Stream中的前N个元素，返回剩下的元素所组成的新Stream。
         * 如果原Stream的元素个数大于N，将返回原Stream的后（原Stream长度-N）个元素
         * 所组成的新Stream；如果原Stream的元素个数小于或等于N，将返回一个空Stream。
         */
        log.info("----------->skip");
        Stream.of(1, 2, 3, 4, 5)
                .skip(1)
                .forEach(System.out::println);

        System.err.println(strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(".....","[","]")));

        log.debug("创建者模式:{}",getPerson());

    }

    public static Person getPerson(){
        new Random().ints().limit(2).forEach(System.out::println);
       return Person.builder().age(5).build();
    }
}
