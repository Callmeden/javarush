package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
       ArrayList<String>[] arrayLists = new ArrayList[10];
       ArrayList<String> list = new ArrayList<String>();
       for(int i=0;i<5;i++)
           list.add("Aa");
       for(int i=0;i<arrayLists.length;i++)
           arrayLists[i] = list;


        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}