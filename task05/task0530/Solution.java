package com.javarush.task.task05.task0530;

import java.io.*;

/* 
Шеф, что-то не пашет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int a1=Integer.parseInt(a);
        int b1=Integer.parseInt(b);

        int sum = a1 + b1;
        System.out.println("Sum = " + sum);
    }
}
