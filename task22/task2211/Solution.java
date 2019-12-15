package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset c1 = Charset.forName("Windows-1251");
        Charset c2 = StandardCharsets.UTF_8;
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));
        byte[] buf = new byte[inputStream.available()];
        for(int i=0;i<buf.length;i++)
            buf[i]= (byte) inputStream.read();
        String s= new String(buf,c1);
        byte[] bytes=s.getBytes(c2);
        outputStream.write(bytes);
        inputStream.close();
        outputStream.close();
    }
}
