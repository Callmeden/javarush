package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] j = new int[1];
            j[5]=3;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            exceptions.add(10,exceptions.get(0));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int [] k = new int [-1];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int [] l = new int[Integer.parseInt(null)];
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            ArrayList<Integer> arrayList = new ArrayList<>(-2);
        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new IllegalAccessException());
        exceptions.add(new IllegalMonitorStateException());
        exceptions.add(new IllegalThreadStateException());
        exceptions.add(new IllegalStateException());


        //напишите тут ваш код

    }
}
