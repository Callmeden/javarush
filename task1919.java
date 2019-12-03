package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        String name;
        double value;
        TreeMap<String,Double> map = new TreeMap<>(); //treemap для автосортировки
        while(reader.ready()){
            s=reader.readLine();                    //читаем каждую строку
            name=s.split(" ")[0];            //по условию имя и з\п  отделены пробелом, так что в качестве разделителя берём пробел
            value=Double.parseDouble(s.split(" ")[1]); //значение зп
            if(!map.containsKey(name)) map.put(name,value); //добавляем чела
            else map.replace(name,map.get(name)+value); //если есть уже в базе - просто заменяем значение value
        }
        reader.close();
        for(Map.Entry<String,Double> pair:map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue()); //выводим
        }
    }
}
