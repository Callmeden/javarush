package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
     String[] s = new String[]{"мама", "мыла", "раму"};
     ArrayList<String> list = new ArrayList<>();
     for(int i=0; i<s.length;i++)
         list.add(s[i]);
     for(int i=0; i<3;i++)
     {
         list.add( 2*i+1,"именно");
     }
     for(int i=0; i<list.size();i++)
         System.out.println(list.get(i));

    }
}
