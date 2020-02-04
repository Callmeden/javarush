package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            Map<String,Integer> map= new TreeMap<>();
            for(int i=0;i<=35;i++){
                String number=Integer.toString(i,36);
                map.put(number,i);
            }
            // System.out.println(map);
            String string=args[0];
            // System.out.println(string);
            if(!string.matches("\\w+"))
                System.out.println("incorrect");
            else{
                List<String> strings = new ArrayList<>();
                for(int i=0;i<string.length();i++)
                    strings.add(i, String.valueOf(string.charAt(i)).toLowerCase());
                int maxSystem=2;
                for(String s:strings){
                    if(map.containsKey(s))
                        if(map.get(s)+1>maxSystem)
                        maxSystem=map.get(s)+1;
                }
                System.out.println(maxSystem);
            }
        } catch (Exception e) {

        }
        //напишите тут ваш код
    }
}
