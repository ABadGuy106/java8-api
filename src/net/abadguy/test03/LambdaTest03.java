package net.abadguy.test03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T>: 消费型接口
 *          void accept(T t);
 * Supplier<T>: 供给型接口
 *          T get();
 * Function<T,R>:  函数型接口
 *          R apply(T t);
 * Predicate<T>:  断言型接口
 *          boolean test(T t);
 */
public class LambdaTest03 {
    //Consumer<T>-消费型接口
    @Test
    public void test1(){
        happy(10023.2,(m)->{
            System.out.println(m-234);
        });
    }
    public void happy(double momey, Consumer<Double> con){
        con.accept(momey);
    }

    //Supplier<T>: 供给型接口
    @Test
    public void test2(){
        List<Integer> numList = getNumList(20, () -> (int) (Math.random() * 1000));
        numList.forEach(System.out::println);
    }

    //需求：产生指定个数的参数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(sup.get());
        }
        return list;
    }
}
