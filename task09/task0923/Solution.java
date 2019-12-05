package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> Vowels = new ArrayList<>();
        ArrayList<Character> Consonants = new ArrayList<>();
        char[] chars = reader.readLine().toCharArray();
        for(int i=0;i<chars.length;i++) {
            char c = chars[i];
            if (c != ' ')
            {
                if(isVowel(c))
                    Vowels.add(c);
                else Consonants.add(c);
            }
        }
        for(char c1:Vowels)
        {
            System.out.print(c1);
            System.out.print(" ");
        }
        System.out.println();
        for(char c2:Consonants)
        {
            System.out.print(c2);
            System.out.print(" ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}