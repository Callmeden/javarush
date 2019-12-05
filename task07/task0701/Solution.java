package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int[] a = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<20;i++)
            a[i]=Integer.parseInt(reader.readLine());

        return Arrays.copyOf(a,a.length);
    }

    public static int max(int[] array) {
        int a=array[0];
        for(int i=0;i<array.length;i++)
            if (array[i]>a)
                a=array[i];
        return a;
    }
}
