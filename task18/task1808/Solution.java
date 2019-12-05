package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);
        if(inputStream.available()%2==1) {
            byte[] buffer1 = new byte[inputStream.available() / 2 + 1];
            int count = inputStream.read(buffer1);
            outputStream1.write(buffer1, 0, count);
            byte[] buffer2 = new byte[inputStream.available()];
            count = inputStream.read(buffer2);
            outputStream2.write(buffer2, 0, count);
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        }
        else {
            byte[] buffer1 = new byte[inputStream.available() / 2];
            int count = inputStream.read(buffer1);
            outputStream1.write(buffer1, 0, count);
            byte[] buffer2 = new byte[inputStream.available()];
            count = inputStream.read(buffer2);
            outputStream2.write(buffer2, 0, count);
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        }
    }
}
