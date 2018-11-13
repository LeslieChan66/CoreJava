package com.CoreJava.Chapter4.Static;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 1:20 2018/6/27
 */

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee employee : staff)
        {
            employee.setId();
            System.out.println("name=" + employee.getName() + ", id=" + employee.getId() + ", salary=" + employee.getSalary());
        }
    }
}

class Employee
{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Harry", 50000);
        System.out.println(employee.getName() + " " + employee.getSalary());
    }
}
