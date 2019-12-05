package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
    static{
        try {
            FileInputStream fileInputStream = new FileInputStream(Statics.FILE_NAME);
            Scanner scanner = new Scanner(fileInputStream);
            while(scanner.hasNextLine())
                lines.add(scanner.nextLine());

        } catch (FileNotFoundException e) {

        }

    }
}
