package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
        public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("a" ,"a");
        map.put("b" ,"a");
        map.put("c" ,"a");
        map.put("d" ,"a");
        map.put("e" ,"a");
        map.put("f" ,"a");
        map.put("g" ,"a");
        map.put("h" ,"a");
        map.put("i" ,"a");
        map.put("j" ,"a");
     return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        int count=0;
        while(iterator.hasNext())
        {
            Map.Entry<String,String> pair = iterator.next();
            if(pair.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        int count=0;
        while(iterator.hasNext())
        {
            Map.Entry<String,String> pair = iterator.next();
            if(pair.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
