package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String,Cat> map = new HashMap<>();
        Cat cat1 = new Cat("V");
        Cat cat2 = new Cat("Va");
        Cat cat3 = new Cat("Vas");
        Cat cat4 = new Cat("Vasy");
        Cat cat5 = new Cat("Vasya");
        Cat cat6 = new Cat("Vasyan");
        Cat cat7 = new Cat("Vasyano");
        Cat cat8 = new Cat("Vasyanov");
        Cat cat9 = new Cat("Vasyanovi");
        Cat cat10 = new Cat("Vasyanovik");
        map.put(cat1.name,cat1);
        map.put(cat2.name,cat2);
        map.put(cat3.name,cat3);
        map.put(cat4.name,cat4);
        map.put(cat5.name,cat5);
        map.put(cat6.name,cat6);
        map.put(cat7.name,cat7);
        map.put(cat8.name,cat8);
        map.put(cat9.name,cat9);
        map.put(cat10.name,cat10);
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Map<String,Cat> copy = new HashMap<>(map);
        Set<Cat> set = new HashSet<>();
        set.addAll(copy.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
