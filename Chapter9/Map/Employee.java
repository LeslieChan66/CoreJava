package com.CoreJava.Chapter9.Map;

/**
 * @Description: a minimalist employee class for testing purposes.
 * @author: Leslie Chan
 * @Date: 0:13 2018/6/28
 */

public class Employee {
    private String name;
    private double salary;

    public Employee(String name)
    {
        this.name = name;
        salary = 0;
    }

    public String toString()
    {
        return "[name=" + name + ", salary=" + salary + "]";
    }
}
