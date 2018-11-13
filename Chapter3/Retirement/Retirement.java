package com.CoreJava.Chapter3.Retirement;

import java.util.Scanner;

/**
* @Description: This program demonstrates a <code>while</code> loop
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-24
*/

public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money did you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("Interst rate in %: ");
        double interstRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        //update account balance while goal isn't reached
        while (balance < goal)
        {
            //add this year's payment add interst
            balance += payment;
            double interest = balance * interstRate / 100;
            balance += interest;
            year++;
        }

        System.out.println("You can retire in " + year + "years.");
    }
}
