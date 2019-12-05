package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s1 = reader.readLine();
       String s2 = reader.readLine();
       String s3 = reader.readLine();
       int a = Integer.parseInt(s1);
       int b = Integer.parseInt(s2);
       int c = Integer.parseInt(s3);
       int countplus=0;
       int countminus=0;
       if (a>0) countplus++;
       else if(a<0) countminus++;
       if (b>0) countplus++;
       else if(b<0) countminus++;
       if (c>0) countplus++;
       else if(c<0) countminus++;
        System.out.println("количество отрицательных чисел: " +countminus);
        System.out.println("количество положительных чисел: "+ countplus);

    }
}
