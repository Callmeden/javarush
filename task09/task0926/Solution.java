package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> a = new ArrayList<>();
        int[] a1 = new int[5];
        for(int i=0;i<a1.length;i++)
            a1[i]=i;
        int[] a2 = new int[2];
        for(int i=0;i<a2.length;i++)
            a2[i]=i;
        int[] a3 = new int[4];
        for(int i=0;i<a3.length;i++)
            a3[i]=i;
        int[] a4 = new int[7];
        for(int i=0;i<a4.length;i++)
            a4[i]=i;
        int[] a5 = new int[0];
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        return a;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
