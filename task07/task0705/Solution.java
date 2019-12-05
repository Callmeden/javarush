package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int [20];
        int[] x1 = new int [10];
        int[] x2 = new int [10];
        for(int i=0; i<20;i++)
            x[i] = Integer.parseInt(reader.readLine());
        x1 = Arrays.copyOfRange(x,0,10);
        x2 = Arrays.copyOfRange(x,10,20);
        for(int i=0;i<10;i++)
            System.out.println(x2[i]);

    }
}
