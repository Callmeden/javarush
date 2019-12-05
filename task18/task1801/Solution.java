package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int max = inputStream.read();
        while (inputStream.available()>0)
        {
           int data = inputStream.read();
           if (data > max) max=data;
        }
        System.out.println(max);
        inputStream.close();
    }
}
