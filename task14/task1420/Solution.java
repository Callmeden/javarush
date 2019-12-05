package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a<1) throw new Exception();
        int b = Integer.parseInt(reader.readLine());
        if (b<1) throw new Exception();
        int nod=1;
        for(int i= 1;i<=a;i++)
            if (a%i==0 && b%i==0) nod=i;
        System.out.println(nod);
    }
}
