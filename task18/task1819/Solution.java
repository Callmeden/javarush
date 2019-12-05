package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(s));
        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(reader.readLine()));
        byte[] buf1 = new byte[bis1.available()];
        byte[] buf2 = new byte[bis2.available()];
        for(int i=0;i<buf1.length;i++)
            buf1[i]= (byte) bis1.read();
        for(int i=0;i<buf2.length;i++)
            buf2[i]= (byte) bis2.read();
        bis1.close();
        bis2.close();
        BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(s));
        bos1.write(buf2);
        bos1.write(buf1);
        reader.close();
        bos1.close();
    }
}
