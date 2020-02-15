package net.abadguy.stream.test01;

import net.abadguy.lambda.test01.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 *     1、创建Stream
 *
 *     2、中间操作
 *
 *     3、终止操作(终端操作)
 */
public class TestStreamAPI1 {
    //创建Stream
    @Test
    public void test1(){
        //1、可以通过Collection系列集合提供的Stream()或parallelStream()
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();
        //2、可以通过Arrays中的静态方法stream()获取数组流
        Employee[] emps=new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);
        //3、通过Stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        //4、创建无限流

        //迭代
        Stream<Integer> stream3=Stream.iterate(0,(x)->x+2);
        stream3.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(()->(int)Math.random()).forEach(System.out::println);
    }
}
