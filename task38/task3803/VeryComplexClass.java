package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;
import java.util.HashSet;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = 0;
        System.out.println((String) x);
    }

    public void methodThrowsNullPointerException() {
        Integer nullInteger = null;
        System.out.println(nullInteger==5);
    }

    public static void main(String[] args) {

    }
}
