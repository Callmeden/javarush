package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Scanner scanner = new Scanner(fileInputStream);
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextLine())
         list.add(Integer.parseInt(scanner.nextLine()));
        for(int i=0;i<list.size();i++)
        {
            if(Math.abs(list.get(i)%2)==1) {list.remove(i); i--;}
        }
        int b;
        for(int i=0;i<list.size();i++)
            for(int j=0;j<list.size()-1;j++)
                if(list.get(j)>list.get(j+1)) {
                    b=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,b);
                }
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
         reader.close();
         fileInputStream.close();


        // напишите тут ваш код
    }
}
