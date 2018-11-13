package com.CoreJava.Chapter8.pair3;

import java.time.LocalDate;

/**
* @Description:
* @param: name, salary, year, month, day
* @return:
* @author: Leslie Chan
* @Date: 2018-06-24
*/
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireday;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireday = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireday() {
        return hireday;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
