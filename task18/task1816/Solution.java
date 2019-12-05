package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count=0; int s;
        while(inputStream.available()>0){
            s=inputStream.read();
            if(s>64 & s<91 || s>96 & s<123) count++;
        }
        System.out.println(count);
        inputStream.close();

    }
}
