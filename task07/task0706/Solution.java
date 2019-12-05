package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] x = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int even =0, odd = 0;
        for(int i=0;i<=14;i++)
            x[i]= Integer.parseInt(reader.readLine());
        for(int i=0;i<=14;i+=2)
            even += x[i];
        for(int i=1;i<=13;i+=2)
            odd += x[i];
        if (even>odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else if (odd>even) System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
