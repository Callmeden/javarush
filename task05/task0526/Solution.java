package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Woman Lena = new Woman("Lena",31,"Limozha");
        Woman Alena = new Woman("Alena", 44,"Chaikinoi");
        Man Den = new Man("Den",24,"Chaikinoi");
        Man Andrew = new Man("Andrew",50,"Solomovoi");
        System.out.println(Lena.name + " " + Lena.age + " " + Lena.address);
        System.out.println(Alena.name + " " + Alena.age + " " + Alena.address);
        System.out.println(Den.name + " " + Den.age + " " + Den.address);
        System.out.println(Andrew.name + " " + Andrew.age + " " + Andrew.address);
    }

    public static class Man {
        int age;
        String name,address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
    public static class Woman {
        int age;
        String name,address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
}
