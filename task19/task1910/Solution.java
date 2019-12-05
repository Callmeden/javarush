package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
        while(bufferedReader.ready()) stringBuilder.append((char)bufferedReader.read());
        Pattern p = Pattern.compile("(\\w+?|\\s)");
        Matcher matcher = p.matcher(stringBuilder);
        while(matcher.find()){
            bufferedWriter.write(stringBuilder.substring(matcher.start(),matcher.end()));
        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
