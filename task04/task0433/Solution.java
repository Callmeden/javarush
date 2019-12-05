package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
       int i=1;
       while(i<11) {
           int j = 1;
           while(j<11)
           {
               System.out.print("S");
               j++;
           }
           System.out.println();
           i++;
       }
    }
}
