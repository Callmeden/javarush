package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s.length()==0)
            return 0;
        int maxLength = 0;
        List<Character> symbols = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            Character symbol = s.charAt(i);
       //     System.out.println("Current symbol is: "+symbol);

            for(int j=0; j<symbols.size();j++){
                if(symbols.get(j).equals(symbol)){
                    symbols.subList(0,j+1).clear();
                }
            }

            symbols.add(symbol);
          //  System.out.println("Current Symbols List: "+symbols);
            if(symbols.size()>maxLength)
                maxLength = symbols.size();
        }

        return maxLength;
    }
}
