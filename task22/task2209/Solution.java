package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while(reader1.ready()){
            sb.append(reader1.readLine());
            sb.append(" ");
        }
        String string = sb.toString().trim();
        String[] strings = string.split("\\s+");
        StringBuilder result = getLine(strings);
        System.out.println(result.toString().trim());
    }

    public static StringBuilder getLine(String... words) {
        String[] strings = new String[words.length];
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        Collections.shuffle(list);
        for(int i=0;i<list.size();i++)
            strings[i]=list.get(i);
        for(int i=0;i<strings.length-1;i++)
            for(int j=i+1;j<strings.length;j++){
                if(strings[i].toUpperCase().charAt(strings[i].length()-1)==strings[j].toUpperCase().charAt(0))
                {
                    String s = strings[i+1];
                    strings[i+1]=strings[j];
                    strings[j]=s;
                    break;
                }
        }
        StringBuilder sb=new StringBuilder();
        for(String s:strings)
            sb.append(s).append(" ");
        return sb;
    }
}
