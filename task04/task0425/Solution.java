package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/



import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa= reader.readLine();
        String sb = reader.readLine();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        if(a>0&&b>0) System.out.println(1);
        else if (a>0&&b<0) System.out.println(4);
        else if (a<0&&b<0) System.out.println(3);
        else System.out.println(2);

    }
}
