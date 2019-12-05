package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[20];
        for(int i=0;i<20;i++)
            x[i]=Integer.parseInt(reader.readLine());
        int maximum=x[0];
        int minimum=x[0];
        for(int i=1;i<20;i++)
        {
            if(x[i]>maximum) maximum=x[i];
            if(x[i]<minimum) minimum=x[i];
        }


        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
