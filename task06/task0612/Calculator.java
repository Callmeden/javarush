package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {

        return a+b;
    }

    public static int minus(int a, int b) {

        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
       double r = a;
       double t = b;
        return r/t;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return 0.01*b*a;
    }

    public static void main(String[] args) {

    }
}