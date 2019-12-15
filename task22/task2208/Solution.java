package com.javarush.task.task22.task2208;


import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static String getQuery(Map<String, String> params) {
        if (params.isEmpty()) return "";
        StringBuilder sb= new StringBuilder();
        for (String key:params.keySet()) {
            if (params.get(key) != null) {
                sb.append(key + " = '"+ params.get(key)+"' and ");
            }
        }
        if (sb.length()>0)  return sb.substring(0, sb.length() -5);
        return "";
    }
}
