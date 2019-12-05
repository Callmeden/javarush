package com.javarush.task.task08.task0821;

import java.util.*;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String,String> map = new HashMap<>();


        map.put("Иванов","qwe");
        map.put("Иванов","qwer");
        map.put("abd","qwet");
        map.put("abe","qwert");
        map.put("abf","qwert");
        map.put("abg","abw");
        map.put("abh","abtt");
        map.put("abj","abgf");
        map.put("abk","abhfh");
        map.put("abl","abjhj");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
