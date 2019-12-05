package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s1 = reader.readLine();
       String s2 = reader.readLine();
       String s3 = reader.readLine();
       String s4 = reader.readLine();
       int a = Integer.parseInt(s1);
       int b = Integer.parseInt(s2);
       int c = Integer.parseInt(s3);
       int d = Integer.parseInt(s4);
       if(a>=b&&a>=c&&a>=d) System.out.println(a);
       else if(b>=a&&b>=c&&b>=d) System.out.println(b);
       else if(c>=a&&c>=b&&c>=d) System.out.println(c);
       else System.out.println(d);
            }
}
