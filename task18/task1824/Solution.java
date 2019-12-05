package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = null;
        BufferedInputStream inputStream = null;
        try {while(true){

                file = reader.readLine();
                inputStream = new BufferedInputStream(new FileInputStream(file));
                inputStream.close();
            } }
        catch (FileNotFoundException e) {
                System.out.println(file);
            }
        reader.close();
        }

    }
