package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        while(true) {
            int value = 0;
            try {
                value = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                break;
            } catch (IOException e) {
                break;
            }
            if (value == ' ') break;
            String key = null;
            try {
                key = reader.readLine();
            } catch (IOException e) {
                break;
            }
            if (key.equals("")) {
                map.put(key, value);
                break;
            }
            map.put(key, value);
        }
        for(Map.Entry<String,Integer> pair : map.entrySet())
        System.out.println(pair.getValue() + " " + pair.getKey());
    }
}