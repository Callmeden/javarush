package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        DateFormat dateFormat1 = new SimpleDateFormat("y'-'MM'-'dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, y", Locale.ENGLISH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = dateFormat1.parse(reader.readLine());
        System.out.println(dateFormat2.format(date).toUpperCase());
    }
}
