package net.abadguy.lambda.test01;


public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(Integer age) {
        this.age=age;
    }
    public Employee(String name,Integer age) {
        this.age=age;
        this.name=name;
    }


    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
