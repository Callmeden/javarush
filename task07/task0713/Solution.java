package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(20);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<20;i++)
            list.add(Integer.parseInt(reader.readLine()));
        for(int i=0;i<20;i++)
        {
            int x = list.get(i);
            if(x%3==0) list1.add(x);
            if(x%2==0) list2.add(x);
            if(x%2!=0&&x%3!=0) list3.add(x);
        }
        printList(list1);
        printList(list2);
        printList(list3);
    }

    public static void printList(ArrayList<Integer> list) {
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
