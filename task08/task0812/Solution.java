package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>() ;
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++)
            list.add(Integer.parseInt(reader.readLine()));
        int[] a = new int[10];
        int max =1;
        a[0] = 1;
        for(int i=1;i<10;i++)
        {
            if(list.get(i).equals(list.get(i-1))) max++;
            else max=1;
            a[i]=max;
        }
        for(int i=0;i<10;i++)
        {
            if(a[i]>max) max=a[i];
        }
        System.out.println(max);
    }
}