package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> strings = new ArrayList<>();
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String outfile = file.split(".part")[0];
        while (!file.equals("end")) {
            strings.add(file);
            file = reader.readLine();
            count++;
        }
        reader.close();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outfile));
        for(int i=1;i<=count;i++){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(outfile+".part"+i));
            byte[] buf = new byte[inputStream.available()];
            int c = inputStream.read(buf);
            outputStream.write(buf);
            inputStream.close();

        }
        outputStream.close();
    }
}

