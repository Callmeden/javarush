package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        Pattern p= Pattern.compile("te");
        StringBuilder st=new StringBuilder(outputStream.toString());
        Matcher matcher = p.matcher(st);
        while(matcher.find())
        st.replace(matcher.start(),matcher.end(),"??");
        System.setOut(consoleStream);
        System.out.println(st);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
