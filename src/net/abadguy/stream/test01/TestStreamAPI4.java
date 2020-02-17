package net.abadguy.stream.test01;

import net.abadguy.lambda.test01.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * 终止操作
 */
public class TestStreamAPI4 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 10023.34, Employee.Status.FERR),
            new Employee("李四", 19, 2341.32,Employee.Status.BUSY),
            new Employee("王五", 20, 4567.23,Employee.Status.WOCATION),
            new Employee("赵六", 21, 9876.32,Employee.Status.FERR),
            new Employee("熊七", 22, 4321.22,Employee.Status.BUSY),
            new Employee("田八", 23, 8965.32,Employee.Status.WOCATION),
            new Employee("狗蛋", 24, 9999.99,Employee.Status.FERR)
    );
    /**
     * 归约
     * reduce(T identity,BinaryOperator)/reduce(BinaryOperator)
     * 可以将流中元素反复结合起来，得到一个值
     */
}
