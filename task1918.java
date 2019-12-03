package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        StringBuilder code = new StringBuilder();
        while (input.ready()) code.append(input.readLine());

        String[] slicedCode = code.toString().split("(?=<" + tag + ".*?>)|(?<=</" + tag + ">)");

        ArrayList<String> rawList = new ArrayList<>();
        for (String s : slicedCode) if (s.matches("(^<" + tag + ".*>.*)|(.*</" + tag + ">$)")) rawList.add(s);

        System.out.println(printTagList(rawList, tag));
        input.close();
    }

    static String printTagList(ArrayList<String> list, String tag) {
        StringBuilder result = new StringBuilder();
        TreeSet<Integer> linesToSkip = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (linesToSkip.contains(i)) continue;
            if (list.get(i).matches("^<" + tag + ".*?>.*") && list.get(i).matches(".*</" + tag + ">$")) {
                result.append(list.get(i)).append(System.lineSeparator());
            } else {
                int j = i;
                int stack = 0;
                do {
                    if (list.get(j).matches("^<" + tag + ".*?>.*")
                            && list.get(j).matches(".*</" + tag + ">$")) {
                        result.append(list.get(j));
                    } else if (list.get(j).matches("^<" + tag + ".*?>.*")) {
                        result.append(list.get(j));
                        stack++;
                    } else if (list.get(j).matches(".*</" + tag + ">$")) {
                        result.append(list.get(j));
                        stack--;
                        linesToSkip.add(j);
                    }
                    j++;
                } while (stack != 0);
                result.append(System.lineSeparator());
            }

        }
        return result.toString();
    }
}
