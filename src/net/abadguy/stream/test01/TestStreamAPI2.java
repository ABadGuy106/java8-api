package net.abadguy.stream.test01;

import net.abadguy.lambda.test01.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 * 1、创建Stream
 * <p>
 * 2、中间操作
 * <p>
 * 3、终止操作(终端操作)
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 10023.34),
            new Employee("李四", 19, 2341.32),
            new Employee("王五", 20, 4567.23),
            new Employee("赵六", 21, 9876.32),
            new Employee("熊七", 22, 4321.22),
            new Employee("田八", 23, 8965.32),
            new Employee("田八", 23, 8965.32),
            new Employee("田八", 23, 8965.32),
            new Employee("田八", 23, 8965.32),
            new Employee("田八", 23, 8965.32),
            new Employee("狗蛋", 24, 9999.99)
    );
    /**中间操作**/
    /**
     * 筛选与切片
     * filter-接收Lambda，从流中排除某些元素
     * limit-截断流，使其元素不超过给定的数量
     * skip(n)-跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回空流。与limit(n)互补
     * distinct-筛选，通过流所生成元素的hashCode()
     */
    @Test
    public void test1() {
        //中间操作：不会执行任何操作
        Stream<Employee> stream=employees.stream().filter(e->e.getAge()>21);
        //终止操作:一次性执行全部内容，即"惰性求值"
        stream.forEach(System.out::println);
    }
    @Test
    public void test2(){
        employees.stream()
                .filter(e -> e.getSalary() > 4000)
                .limit(2)
                .forEach(System.out::println);
    }
    @Test
    public void test3(){
        employees.stream()
                .filter(e->e.getSalary()<8000)
                .skip(2)
                .forEach(System.out::println);
    }
    //需要重写equals和hash方法
    @Test
    public void test4(){
        employees.stream()
                .distinct()
                .forEach(System.out::println);
    }
    /**
     *
     * 映射
     * map-接收Lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数。
     *      该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap-接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */
    @Test
    public void test5(){
        List<String> list=Arrays.asList("aa","bb","cc","dd","ee","ff");
        list.stream().map(str->str.toUpperCase())
                .forEach(System.out::print);
        System.out.println("---------------------");
        employees.stream().map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("---------------------");
        Stream<Stream<Character>> stream=list.stream().map(TestStreamAPI2::filterCharacter);
        stream.forEach(sm->sm.forEach(System.out::println));
        System.out.println("=================");
        list.stream().flatMap(TestStreamAPI2::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list=new ArrayList<>();
        for (Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    /**
     * 排序
     * sorted()-自然排序
     * sorted(Compartor com)-定制排序
     */
    @Test
    public void test7(){
        List<String> list=Arrays.asList("ee","cc","aa","dd","bb","ff");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--------------------");
        employees.stream()
                .sorted((e1,e2)->{
                   if(e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                   }else {
                       return ((Integer)e1.getAge())
                               .compareTo((Integer)e2.getAge());
                   }
                }).forEach(System.out::println);
    }
}
