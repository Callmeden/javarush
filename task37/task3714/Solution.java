package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int minValue=1; //чтобы не возникло трудностей с числами IV, IX, и т.п.
        int result = 0;
        int value;
        char letter;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>0){
            letter = sb.charAt(sb.length()-1);
            value = map.get(letter);
            if(value>=minValue){
                result += value;
                minValue = value;
            }
            else
                result -= value;
            sb.deleteCharAt(sb.length()-1);
        }
        return result;
    }
}
