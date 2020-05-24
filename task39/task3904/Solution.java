package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.List;

/*
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        long result;
        if(n<0) return 0;
        if(n==0) return 1;
        List<Long> results = new ArrayList<>();
        results.add(1L);        // 1 ступенька
        results.add(2L);        // 2 ступеньки
        results.add(4L);        // 3 ступеньки

        for(int i=3;i<n;i++){
              long summ = results.get(i-3)+results.get(i-2)+results.get(i-1);
              results.add(summ);
            }
        result = results.get(n-1);

        return result;
    }
}

