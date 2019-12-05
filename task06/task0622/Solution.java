package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[5];
        for (int i=0;i<=4;i++)
            num[i]=Integer.parseInt(reader.readLine());
        int a;
        for(int j=1;j<=4;j++)
            for(int i=1;i<=4;i++)
            {

                if (num[i]<num[i-1]) {
                    a=num[i-1];
                    num[i-1]=num[i];
                    num[i]=a;
                }
            }
        for(int i=0;i<=4;i++)
            System.out.println(num[i]);
        //напишите тут ваш код
    }
}
