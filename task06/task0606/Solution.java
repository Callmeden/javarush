package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even=0;
    public static int odd=0;

    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int a = Integer.parseInt(reader.readLine());

       while(true)
       {
        if (a%2==0)  even++;
        else odd++;
        if (Math.abs(a)<=9) break;
        else a=a/10;
       }
        System.out.println("Even: "+even+" Odd: "+odd);

    }
}
