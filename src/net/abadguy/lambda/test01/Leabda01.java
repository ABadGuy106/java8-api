package net.abadguy.lambda.test01;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Leabda01 {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts=new TreeSet<>(com);
    }

    //Lambda表达式
    public void test2(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts=new TreeSet<>(comparator);
    }


    List<Employee> employees= Arrays.asList(
      new Employee("张三",18,10023.34),
      new Employee("李四",19,2341.32),
      new Employee("王五",20,4567.23),
      new Employee("赵六",21,9876.32),
      new Employee("熊七",22,4321.22),
      new Employee("田八",23,8965.32),
      new Employee("狗蛋",24,9999.99)
    );

    //获取当前公司中员工年龄大于21的员工信息
    public List<Employee> filterEmployees(List<Employee> list,Integer age){
        List<Employee> emps=new ArrayList<>();
        for(Employee employee:list){
            if(employee.getAge()>=age){
                emps.add(employee);
            }
        }
        return emps;
    }
    @Test
    public void test3(){
        System.out.println(filterEmployees(employees,21));
    }
    //获取当前公司中员工工资大于5000的员工信息


    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> myPredicate){
        List<Employee> myList=new ArrayList<>();
        for(Employee e:list){
            if (myPredicate.test(e)){
                myList.add(e);
            }
        }
        return myList;
    }

    @Test
    public void test5(){
        List<Employee> employeesList = filterEmployee(this.employees, (e) -> {
            return e.getSalary() <= 5000;
        });
        System.out.println(employeesList);
    }

    @Test
    public void test6(){
        employees.stream().filter((e)->e.getSalary()>5000).forEach(System.out::println);
    }

    @Test
    public void test7(){
        employees.stream().filter((e)->e.getSalary()>5000).limit(2).forEach(System.out::println);
    }

    @Test
    public void test8(){
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
