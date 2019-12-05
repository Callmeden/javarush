package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
   String name,color, address;
   int age,weight;
   public void initialize(String name) {
       this.name= name;
       this.weight=5;
       this.color="white";
       this.age=10;
   }
   public void initialize(String name,int weight, int age) {
       this.name= name;
       this.weight=weight;
       this.color="white";
       this.age=age;
   }
   public void initialize(String name, int age){
       this.name=name;
       this.age=age;
       this.weight=5;
       this.color="white";
   }
   public void initialize(int weight,String color) {
       this.weight=weight;
       this.color=color;
       this.age=10;
   }
   public void initialize(int weight,String color,String address) {
       this.weight=weight;
       this.color=color;
       this.address=address;
       this.age=10;
   }


    public static void main(String[] args) {

    }
}
