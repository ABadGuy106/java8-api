package net.abadguy.stream.test01;

import net.abadguy.lambda.test01.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 终止操作
 */
public class TestStreamAPI3 {
    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素的总个数
     * max-返回流中最大值
     * min-返回流中最小值
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 10023.34, Employee.Status.FERR),
            new Employee("李四", 19, 2341.32,Employee.Status.BUSY),
            new Employee("王五", 20, 4567.23,Employee.Status.WOCATION),
            new Employee("赵六", 21, 9876.32,Employee.Status.FERR),
            new Employee("熊七", 22, 4321.22,Employee.Status.BUSY),
            new Employee("田八", 23, 8965.32,Employee.Status.WOCATION),
            new Employee("狗蛋", 24, 9999.99,Employee.Status.FERR)
    );
    @Test
    public void test1(){
        boolean b = employees.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("----------------------");
        boolean b1 = employees.stream()
                .anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
        System.out.println("----------------------");
        boolean b2 = employees.stream()
                .noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
    }
}
