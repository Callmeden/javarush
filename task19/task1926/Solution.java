package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while(reader1.ready()){
            String s=reader1.readLine();
            char[] chars = s.toCharArray();
            for(int i=chars.length-1;i>=0;i--)
                System.out.print(chars[i]);
            System.out.println();
        }
        reader1.close();
    }
}
