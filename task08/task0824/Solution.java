package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> children = new ArrayList<>();
        ArrayList<Human> childrenn = new ArrayList<>();
        Human den = new Human("denis",true,24,childrenn);
        Human max = new Human("max",true,16,childrenn);
        Human vera = new Human("vera",false,3,childrenn);
        children.add(max);
        children.add(den);
        children.add(vera);
        Human andrei = new Human("andrei",true,50,children);
        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(andrei);
        Human arkadii = new Human("arkadii",true,78,children1);
        Human taisa = new Human("taisa",false,75,children1);
        Human lena = new Human("lena",false,45,children);
        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(lena);
        Human tolik = new Human("tolik",true,70,children2);
        Human valya = new Human("valya",false,65,children2);
        System.out.println(arkadii.toString());
        System.out.println(tolik.toString());
        System.out.println(taisa.toString());
        System.out.println(valya.toString());
        System.out.println(andrei.toString());
        System.out.println(lena.toString());
        System.out.println(den.toString());
        System.out.println(max.toString());
        System.out.println(vera.toString());
           }

    public static class Human {
       public int age;
       public String name;
       public boolean sex;
       ArrayList<Human> children = new ArrayList<>();


       public Human(String name,boolean sex,int age,ArrayList children){
           this.name = name;
           this.sex = sex;
           this.age = age;
           this.children = children;
       }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
