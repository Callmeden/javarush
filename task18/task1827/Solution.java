package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxid=0;
        reader.close();
        if(args.length!=0){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            String s;
            char[] c;
            String s1;
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNextLine()){
                s=scanner.nextLine();
                s1="";
                c=s.toCharArray();
                int j =0;
                while(c[j]!=' ' && j<8){
                    s1= s1+c[j];
                    j++;
                }
                if(Integer.parseInt(s1)>maxid) maxid=Integer.parseInt(s1); //maxid+1 - id которое нужно добавить
            }
            maxid=maxid+1;
            scanner.close();
            inputStream.close();
            String productName = args[1];
            char[] namechar = new char[30];
            for(int i=0;i<namechar.length;i++)
            if(i<productName.toCharArray().length)
                namechar[i] =productName.toCharArray()[i];
            else namechar[i]=' ';
                                 //namechar[0-29] имя продукта
            String price = args[2];
            char[] pricechar = new char[8];
            for(int i=0;i<pricechar.length;i++)
            if(i<price.toCharArray().length)
                pricechar[i] =price.toCharArray()[i];
            else pricechar[i]=' ';

            String quantity = args[3];
            char[] quantitychar = new char[4];
            for(int i=0;i<quantitychar.length;i++)
            if(i<quantity.toCharArray().length)
                quantitychar[i] =quantity.toCharArray()[i];
            else quantitychar[i]=' ';
            //quantitychar[0-3] количество
            String result = String.valueOf(maxid);
            for(char ch: namechar)
                result= result+ch;
            for(char ch: pricechar)
                result= result+ch;
            for(char ch: quantitychar)
                result= result+ch;
            result="\n"+result;
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            out.write(result);
            out.close();
        }



        //outputStream.printf("%n%-8d%-30.30s%-8.2f%-4d", getNextId(filename), productName, price, quantity);
    }
}
