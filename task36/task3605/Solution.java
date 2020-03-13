package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> set = new TreeSet<>();

        while(reader.ready()){
            char[] buf = reader.readLine().toLowerCase().toCharArray();
            for(Character c:buf)
               if(Character.isLetter(c)) set.add(c);
        }

        if(set.size()<5)
            for(char c: set)
                System.out.print(c);
        else
        {
            int count =0;
            while(count<5){
                System.out.print(set.first());
                set.remove(set.first());
                count++;
            }
        }
    }
}
