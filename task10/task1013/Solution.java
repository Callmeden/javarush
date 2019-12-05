package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        private String name;
        private int age;
        private String lastname ;
        private int weight;
        private int height;
        private boolean sex;

        public Human(int age) { //1
            this.age = age;
        }
        public Human(int age,int weight) { //2
            this.age = age;
            this.weight=weight;
        }

        public Human(String name) {  //3
            this.name = name;
        }
        public Human(String name,String lastname){ //4
            this.name=name;
            this.lastname=lastname;
        }
        public Human(boolean sex){         //5
            this.sex = sex;
        }
        public Human(boolean sex,String name) { //6
           this.sex = sex;
           this.name = name;
        }
        public Human(boolean sex,String name,String lastname){//7

        }
        public Human(int age,String lastname,boolean sex){
            //8

        }
        public Human(boolean sex,int weight,String name){
            //9
        }
        public Human(int weight,String name,String lastname,boolean sex){
            //10
        }
    }
}
