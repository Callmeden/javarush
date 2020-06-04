package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("asdfgh","ashfgh"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if(first.equals(second)) return true; //если одинаковы

        if(Math.abs(first.length()-second.length())>1) return false; //если по длине отличаются больше чем на 1.

        if(first.isEmpty() || second.isEmpty())
            return true;
        StringBuilder max = new StringBuilder("A");
        StringBuilder min = new StringBuilder("A");

        if(first.length()>second.length()) {
            max.append(first);
            min.append(second);
        }
        else {
            max.append(second);
            min.append(first);
        }

        if(min.length()==max.length()){
            int differenceNumber = 0;
            for(int i=0;i<min.length();i++)
                if(max.charAt(i)!=min.charAt(i)) {
                    if (differenceNumber == 1)
                        return false;
                    differenceNumber=1;
                }
        } //если длины одинаковы, то остаётся только заменить, проверяем.
    else {
            int differenceNumber = 0;
            for (int i = 0; i < min.length(); i++) {
                if (max.charAt(i) != min.charAt(i)) {
                    if (differenceNumber == 0) {
                        min.insert(i, max.charAt(i));
                        differenceNumber++;
                    } else return false;
                }
            }
        }
        return true;
    }
}
