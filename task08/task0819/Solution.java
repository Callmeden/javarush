package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Cat> copy = new HashSet<>(cats);
        for (Cat cat: copy) {


                cats.remove(cat);
                break;

        }
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats =new HashSet<Cat>();

        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat: cats) {

            System.out.println(cat);
        }
    }

    public static class Cat{
        public String name;
        public Cat(){

        }
    }
}
