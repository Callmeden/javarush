package com.javarush.task.task08.task0827;


import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date time = new Date(date);
        String s = ("JANUARY 1 ");
        int a =  1900+ time.getYear();
        String st =(s+a);
        Date first= new Date(st);
        long l = (time.getTime()-first.getTime())/(1000*60*60*24);
        if (l%2==0) return true;
        else return false;
    }
}
