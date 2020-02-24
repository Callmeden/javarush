package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try {
            RandomAccessFile file = new RandomAccessFile(fileName,"rw");

            file.seek(number);
            byte[] readBytes = new byte[text.length()];
            
            file.read(readBytes,0,readBytes.length);

            String readText = new String(readBytes);
            
            file.seek(file.length());

            if (readText.equals(text)) {
                file.write("true".getBytes());
            } else {
                file.write("false".getBytes());
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
