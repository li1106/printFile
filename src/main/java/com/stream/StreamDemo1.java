package com.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName StreamDemo1
 * @Description TODO 流编程[串行流 stream()]
 * @Author Administrator
 * @Date 2020/6/3 10:55
 */
@Slf4j
public class StreamDemo1 {
    public static void main(String[] args) {
        /**
         * stream() − 为集合创建串行流。
         *
         * parallelStream() − 为集合创建并行流。
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        log.debug("集合数据:{}", strings);
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        log.debug("流编程过滤后:{}", filtered);


        /**
         *
         * 使用 forEach 输出了10个随机数
         */
        log.info("-----------》foreach");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        /**
         * map 方法用于映射每个元素到对应的结果，使用 map 输出了元素对应的平方数：
         */
        log.info("-----------》map");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数 distinct() [去重]
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);


        log.info("-----------》filter");
        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strs.stream().filter(string -> string.isEmpty()).count();
        log.debug("空字符串数量:{}",count);


        log.info("-----------》limit");
        Random random1 = new Random();
        random1.ints().limit(5).forEach(System.out::println);


        log.info("-----------》sorted  升序");
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(System.out::println);
    }
}
