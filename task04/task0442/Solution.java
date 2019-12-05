package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count =0;
        while (true)
        {
            String s = reader.readLine();
            int a = Integer.parseInt(s);
            count+=a;
            if(a==-1) break;
        }
        System.out.println(count);

    }
}
