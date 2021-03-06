package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(fileName,"rw");
            if(number>file.length())
                number=file.length();
            file.seek(number);
            file.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
