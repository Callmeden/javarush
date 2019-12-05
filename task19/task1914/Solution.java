package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        StringBuilder sb = new StringBuilder(outputStream.toString());
        Pattern p = Pattern.compile("\\d+");
        Matcher matcher = p.matcher(sb);
        ArrayList<Integer> list = new ArrayList<>(2);
        while(matcher.find()) list.add(Integer.parseInt(sb.substring(matcher.start(),matcher.end())));
        if(sb.indexOf("+")>0) sb.append((list.get(0) + list.get(1)));
        if(sb.indexOf("*")>0) sb.append((list.get(0) * list.get(1)));
        if(sb.indexOf("-")>0) sb.append((list.get(0) - list.get(1)));
        System.setOut(consoleStream);
        System.out.println(sb);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

