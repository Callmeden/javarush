package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String text = "JavaRush - курсы Java онлайн";
        int count=0;
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        StringBuilder sb = new StringBuilder(outputStream.toString());
        String s = sb.toString();
        String[] strings = s.split("\n");
        StringBuilder result = new StringBuilder();
        for(String line:strings){
            result.append(line+"\n");
            count++;
            if(count!=0 && count%2==0)
                result.append(text+"\n");
        }
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
