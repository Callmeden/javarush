package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s = reader.readLine();
       int a = Integer.parseInt(s);
       int l = s.length();
       if (a<1||a>999){}

       else if (l==1)
       {
           if(a%2==0) System.out.println("четное однозначное число");
           else System.out.println("нечетное однозначное число");
       }
       else if (l==2)
       {
           if(a%2==0) System.out.println("четное двузначное число");
           else System.out.println("нечетное двузначное число");
       }
       else if (l==3)
       {
           if(a%2==0) System.out.println("четное трехзначное число");
           else System.out.println("нечетное трехзначное число");
       }

    }
}
