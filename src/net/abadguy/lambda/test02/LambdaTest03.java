package net.abadguy.lambda.test02;

import net.abadguy.lambda.test01.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest03 {
    List<Employee> employees= Arrays.asList(
            new Employee("张三",18,10023.34),
            new Employee("李四",19,2341.32),
            new Employee("王五",19,4567.23),
            new Employee("赵六",21,9876.32),
            new Employee("熊七",22,4321.22),
            new Employee("田八",22,8965.32),
            new Employee("狗蛋",24,9999.99)
    );

    //调用Collections.sotr()方法，通过定制排序比较两个Employee(先按年龄比
    // 年龄相同按名字)使用Lambda作为参数传递
    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
               return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }

}
