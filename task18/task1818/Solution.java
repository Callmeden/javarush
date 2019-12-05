package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream( reader.readLine(),true));
        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(reader.readLine()));
        BufferedInputStream bis3 = new BufferedInputStream(new FileInputStream(reader.readLine()));
        byte[] buf2 = new byte[bis2.available()];
        byte[] buf3 = new byte[bis3.available()];
        int count2 = bis2.read(buf2);
        int count3 = bis3.read(buf3);
        bos1.write(buf2,0,count2);
        bos1.write(buf3,0,count3);
        bos1.close();
        bis2.close();
        bis3.close();
    }
}
