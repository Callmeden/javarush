package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/*
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats;

    static {
        cat;
    }

    public Cat() {
    }

    public static void main(String[] args) {

        for(int i=0;i<=9;i++){
            Cat cat1 = new Cat();
            cats[i]=cat1;
        }

        printCats();
    }

    public static void printCats() {
       for (int i=0;i<=9;i++){
           System.out.println(cats[i]);
       }
    }
}
