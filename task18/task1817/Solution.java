package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int scount=0;
        int lcount=0; //=inputStream.available();
        while(inputStream.available()>0) {
           if(inputStream.read()==32) scount++;
           lcount++;
        }
        System.out.printf("%.2f",(float)scount/lcount*100);
        inputStream.close();

    }
}
