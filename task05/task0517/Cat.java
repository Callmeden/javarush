package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name,color,address;
    int age,weight;
    public Cat(String name) {
        this.name=name;
        this.age=10;
        this.color="white";
        this.weight=5;
    }
    public Cat(String name,int weight,int age) {
        this.name=name;
        this.age=age;
        this.color="white";
        this.weight=weight;
    }
    public Cat(String name,int age) {
        this.name=name;
        this.age=age;
        this.color="white";
        this.weight=5;
    }
    public Cat(int weight,String color) {
        this.age=10;
        this.color=color;
        this.weight=weight;
    }
    public Cat(int weight,String color,String address) {
        this.age=10;
        this.color=color;
        this.weight=weight;
        this.address=address;
    }

    public static void main(String[] args) {

    }
}
