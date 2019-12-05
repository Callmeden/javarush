package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
       Map<String, Integer> map = new HashMap<String,Integer>();
       map.put("Pervii",500);
       map.put("vtoroi",400);
       map.put("tretii",600);
       map.put("chetvertii",300);
       map.put("Pyatii",600);
       map.put("shestoi",200);
       map.put("sedmoi",501);
       map.put("vosmoi",499);
       map.put("devyatii",300);
       map.put("desyatii",400);
       return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String,Integer> copy = new HashMap<>(map);
        for(Map.Entry<String,Integer> pair: copy.entrySet())
        {
            String key = pair.getKey();
            int value = pair.getValue();
            if(value<500) map.remove(key);
        }

    }

    public static void main(String[] args) {
     removeItemFromMap(createMap());
    }
}