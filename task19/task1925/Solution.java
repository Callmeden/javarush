package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> words=new ArrayList<>();
        while(reader.ready()){
            String s =  reader.readLine();
            String[] strings = s.split(" ");
            for(String word:strings)
                if(word.length()>6) words.add(word);
        }
        reader.close();
        for(int i=0;i<words.size();i++)
            if(i!=words.size()-1) writer.write(words.get(i)+",");
            else writer.write(words.get(i));
        writer.close();
    }

}
