package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        int id;
        String productName="";
        double price;
        int quantity;
        String s;
        Scanner scanner = new Scanner(inputStream);
        s=scanner.nextLine();
        while(scanner.hasNextLine()){
            if(!s.startsWith(args[0]+" ")) s=scanner.nextLine();
            else break;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(s.split(" ")));
        id=Integer.parseInt(arrayList.get(0));
        quantity=Integer.parseInt(arrayList.get(arrayList.size()-1));
        price=Double.parseDouble(arrayList.get(arrayList.size()-2));
        for(int i=1;i<arrayList.size()-2;i++)
            productName=productName+arrayList.get(i)+" ";
        System.out.println(id+" "+productName+""+price+" "+quantity);
        inputStream.close();
    }
}
