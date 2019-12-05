package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<>();
        while(inputStream.available()>0){
            int data = inputStream.read();
            if(!list.contains(data)) list.add(data);
        }
        Collections.sort(list);
        for(int a:list)
            System.out.print(a+" ");
        inputStream.close();

    }
}
