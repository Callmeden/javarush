package com.javarush.task.task15.task1527;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] subStr= s.split("\\?");
        String[] subStr1;
        String s1 = subStr[1];
        subStr = s1.split("&");
        for(int i=0;i<subStr.length;i++)
        {
            subStr1=subStr[i].split("=");
            System.out.print(subStr1[0]+" ");
        }
        if (s.contains("obj=")) {
            subStr = s.split("obj=");
            subStr = subStr[1].split("&");
            try{
                System.out.println(); alert(Double.parseDouble(subStr[0]));}
            catch(NumberFormatException e){alert(subStr[0]);}
        }
    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}