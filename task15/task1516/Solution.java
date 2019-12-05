package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public  Double DoubleVar=null;
    public boolean booleanVar;
    public  Object ObjectVar=null;
    public  Exception ExceptionVar = null;
    public String StringVar=null;
    static Solution sol = new Solution();
    public static void main(String[] args) {

        System.out.println(sol.intVar);
        System.out.println( sol.doubleVar);
        System.out.println( sol.DoubleVar);
        System.out.println(sol.booleanVar);
        System.out.println( sol.ObjectVar);
        System.out.println( sol.ExceptionVar);
        System.out.println( sol.StringVar);


    }


}
