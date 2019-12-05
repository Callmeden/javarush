package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        StringBuilder stringBuilder = new StringBuilder();
        while(bufferedReader.ready())
            stringBuilder.append((char)bufferedReader.read());
        reader.close();
        bufferedReader.close();
        Pattern p = Pattern.compile("(\\b|^)\\d+?(\\b|$)");
        Matcher matcher = p.matcher(stringBuilder);
        while(matcher.find()){
            bufferedWriter.write(stringBuilder.substring(matcher.start(),matcher.end())+" ");
        }
        bufferedWriter.close();
    }
}
