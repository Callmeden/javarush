package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[8];
        byte[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        byte[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        byte[] bigLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        byte[] symbols = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Byte> byteList = new ArrayList<>();
        byteList.add(numbers[(int)(Math.random()*numbers.length)]);

        byteList.add(letters[(int)(Math.random()*letters.length)]);

        byteList.add(bigLetters[(int)(Math.random()*bigLetters.length)]);

        byteList.add(symbols[(int)(Math.random()*symbols.length)]);
        byteList.add(symbols[(int)(Math.random()*symbols.length)]);
        byteList.add(symbols[(int)(Math.random()*symbols.length)]);
        byteList.add(symbols[(int)(Math.random()*symbols.length)]);
        byteList.add(symbols[(int)(Math.random()*symbols.length)]);

        Collections.shuffle(byteList);

        for(int i=0;i<byteList.size();i++)
            bytes[i]=byteList.get(i);

        byteArrayOutputStream.write(bytes);
        return byteArrayOutputStream;
    }
}