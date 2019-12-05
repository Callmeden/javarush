package com.javarush.task.task07.task0707;


import java.io.IOException;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<5;i++)
            list.add("a");
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
