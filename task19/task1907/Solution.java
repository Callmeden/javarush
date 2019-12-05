package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        StringBuilder s = new StringBuilder();
        while(fileReader.ready()){
            s.append((char)fileReader.read());
        }
        String st = s.toString();
        String[] strings = st.split("(\\b|^)world(\\b|$)");
        System.out.println(strings.length-1);
        reader.close();
        fileReader.close();
    }
}
