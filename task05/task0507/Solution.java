package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double count=0, sum=0;
        while (true)
        {
            String s= reader.readLine();
            int n = Integer.parseInt(s);
            if (n==-1) break;
            else {sum+=n;
        count++;}
        }
        double i =sum/count;
        System.out.println(i);
        //напишите тут ваш код
    }
}

