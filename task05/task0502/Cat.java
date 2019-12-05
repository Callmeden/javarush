package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
       int count =0; int count2=0;
       if(this.age>anotherCat.age) count++; else if (this.age<anotherCat.age)count2++;
       if(this.weight>anotherCat.weight) count++; else if (this.weight<anotherCat.weight)count2++;
       if(this.strength>anotherCat.strength) count++; else if (this.strength<anotherCat.strength)count2++;

       if(count>count2) return true;
       else return false;
    }

    public static void main(String[] args) {

    }
}
