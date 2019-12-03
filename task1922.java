package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
           while(reader1.ready()) {
               String s = reader1.readLine();
               String[] strings = s.split(" ");
               int count = 0;
               for (int i = 0; i < strings.length; i++)
                   if (words.contains(strings[i])) count++;
               if (count == 2) System.out.println(s);
           }
        reader1.close();
    }
}
