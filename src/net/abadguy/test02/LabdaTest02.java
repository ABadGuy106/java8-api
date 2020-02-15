package net.abadguy.test02;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的基础语法
 */
public class LabdaTest02 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        new Thread(()-> System.out.println("hello Lambda")).start();
    }
    //语法格式二：有参数，并且无返回值
    @Test
    public void test2(){
        Consumer<String> consumer=(x)-> System.out.println(x);
        consumer.accept("test");
    }
    //语法格式三：若只有一个参数，小括号可以不写
    @Test
    public void test3(){
        Consumer<String> consumer=x-> System.out.println(x);
        consumer.accept("test");
    }
    //语法格式四：有两个以上参数，有返回值，并且Lambda体中有多条语句
    @Test
    public void test4(){
        Comparator<Integer> comparator=(a,b)->{
            System.out.println("函数式接口");
            return Integer.compare(a,b);
        };
        System.out.println(comparator.compare(3,3));
    }
    //语法五：若Lambda体中只有一条语句，renturn 和大括号都可以不写
    @Test
    public void test5(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        System.out.println(comparator.compare(32,30));
    }
}
