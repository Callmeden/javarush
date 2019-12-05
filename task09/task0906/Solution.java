package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        System.out.println(Thread.currentThread().getStackTrace()[2].getClassName() +": "+Thread.currentThread().getStackTrace()[2].getMethodName()+": "+s);
        //мучение, ни одного задания не выполнил не заглядывая в "сторонние" лекции.
        //для тех кто сдался:
        //имя класса - Thread.currentThread().getStackTrace()[X].getClassName()
        //имя метода - Thread.currentThread().getStackTrace()[X].getMethodName()
        //X- заменить на нужное
    }
}
