package com.CoreJava.Chapter9.LinkList;

import javafx.concurrent.Worker;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 18:01 2018/9/4
 */

public class test {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hello");
        list.add(",");
        list.add("world");

        ListIterator iterator = list.listIterator();
        iterator.next();
        iterator.add("leslie");


        System.out.println(list);
    }
}
