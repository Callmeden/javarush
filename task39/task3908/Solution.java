package com.javarush.task.task39.task3908;

import java.util.HashSet;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        int notRepeatingSymbols = 0;
        HashSet<Character> symbols = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder(s.toLowerCase());
        for(int i=0;i<s.length();i++){
            symbols.add(stringBuilder.charAt(i));
        }

        for(Character symbol:symbols){
            int number = 0;
            for(int i=0;i<s.length();i++)
                if (stringBuilder.charAt(i)==symbol)
                    number++;
            if(number%2==1)
                notRepeatingSymbols++;
        }

        return notRepeatingSymbols<2;
    }
}
