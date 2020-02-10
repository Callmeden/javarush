package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        StringBuilder result = new StringBuilder().append(number).append(" =");
        String[] formats = {"", " + %d", " - %d"};

        for (int i = number, tri = 1; i > 0; i = ++i / 3, tri *= 3) {
            int ost = i % 3;
            result.append(String.format(formats[ost], tri));
        }

        System.out.println(result.toString());
    }
}