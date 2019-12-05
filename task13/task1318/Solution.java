package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
        fileInputStream.close();
        reader.close();
        // напишите тут ваш код
    }
}