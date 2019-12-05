package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path =reader.readLine();
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String s;
        while (true){
            s = reader.readLine();
            writer.write(s + "\n");
            if(s.equals("exit")) break;
        }
        reader.close();
        writer.close();
    }
}
