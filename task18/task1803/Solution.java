package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer,Integer> map = new HashMap<>();
        while(inputStream.available()>0){
            int data = inputStream.read();
            int count;
            if(!map.containsKey(data)) map.put(data,1);
            else {
                count = map.get(data)+1;
                map.remove(data);
                map.put(data,count);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int max=0;
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> pair = iterator.next();
            int value = pair.getValue();
                if (value > max) max = value;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer,Integer> pair = iterator2.next();
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == max) System.out.print(key+" ");
        }
        inputStream.close();
    }
}
