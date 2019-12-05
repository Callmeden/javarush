package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human tolik = new Human("tolik",true,70);
        Human valya = new Human("valya",false,65);
        Human arkadii = new Human("arkadii",true,78);
        Human taisa = new Human("taisa",false,73);
        Human lena = new Human("lena",false, 44, tolik,valya);
        Human andrei = new Human("andrei",true,50, arkadii,taisa);
        Human denis = new Human("denis",true,24,andrei,lena);
        Human max = new Human("max",true,16,andrei,lena);
        Human vera = new Human("vera",false,3,andrei,lena);
        System.out.println(tolik);
        System.out.println(valya);
        System.out.println(arkadii);
        System.out.println(taisa);
        System.out.println(lena);
        System.out.println(andrei);
        System.out.println(max);
        System.out.println(denis);
        System.out.println(vera);

    }

    public static class Human {
        public  String name;
        public  boolean sex;
        public  int age;
        public Human father;
        public Human mother;
        public Human(String name,boolean sex,int age){
            this.name=name;
            this.sex =sex;
            this.age = age;
        }
        public Human(String name,boolean sex,int age, Human father, Human mother)
        {
            this.name=name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        @Override
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}