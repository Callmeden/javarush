package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map <String,String> map = new HashMap<String,String>();
        map.put("a","Первый");
        map.put("b","Второй");
        map.put("c","Третий");
        map.put("d","Тетий");
        map.put("e","Тетий");
        map.put("f","Четвертый");
        map.put("g","Пятый");
        map.put("h","Седьмой");
        map.put("j","Седьмой");
        map.put("k","Шестой");

        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String,String> copy = new HashMap<>(map);
        Set<String> set = new HashSet<>();
        for (String name : copy.values())
            if(!set.add(name)) removeItemFromMapByValue(map,name);

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
      removeTheFirstNameDuplicates(createMap());

    }
}
