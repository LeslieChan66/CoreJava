package com.CoreJava.Chapter3.InputTest;

import java.util.Scanner;

/**
* @Description: This pragram demostrates consele input
* @param:
* @return:
* @author: Leslie Chan
* @Date: 2018-06-24
*/
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.println("What is your name");
        String name = in.nextLine();

        //get second input
        System.out.println("How old are you?");
        int age = in.nextInt();

        //display output on console
        System.out.println("Hello " + name + ". Next year you will be " + (age + 1));

    }
}
