package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>(10);
        for(int i=0;i<10;i++)
            list.add(reader.readLine());
        int min = list.get(0).length();
        int max = list.get(0).length();
        for(int i=1;i<10;i++)
        {
            if(min> list.get(i).length()) min = list.get(i).length();
            if(max< list.get(i).length()) max = list.get(i).length();
        }
        int i=0;
        while (true)
         if (list.get(i).length()==min || list.get(i).length()==max) {
             System.out.println(list.get(i));
             break;
         }
             else  i++;
    }
}
