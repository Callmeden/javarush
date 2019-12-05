package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s1= reader.readLine();
       String s2= reader.readLine();
       String s3= reader.readLine();
       int a = Integer.parseInt(s1);
       int b = Integer.parseInt(s2);
       int c = Integer.parseInt(s3);
       if (a>=b&&a>=c)
       {
           System.out.print(a+" ");
           if (b>=c) System.out.print(b+" "+c);
           else System.out.print(c+" "+b);
       }
       else if (b>=a&&b>=c)
       {
           System.out.print(b+" ");
           if (a>=c) System.out.print(a+" "+c);
           else System.out.print(c+" "+a);
       }
       else if(a>=b) System.out.println(c+" "+a+" "+b);
       else System.out.println(c+" "+b+" "+a);

    }
}
