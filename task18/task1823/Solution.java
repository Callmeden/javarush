package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();
        while(!file.equals("exit")){
            ReadThread readThread = new ReadThread(file);
            readThread.start();
            readThread.join();
            readThread.interrupt();
            file = reader.readLine();
        }
     reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private int max;
        private byte maxbyte;
        public ReadThread(String fileName) {
            this.fileName=fileName;
        }

        @Override
        public void run() {
            try {
                this.max = 0;
                this.maxbyte = 0;
                Map<Byte, Integer> map = new HashMap<>();
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                byte[] buf = new byte[inputStream.available()];
                for (int i = 0; i < buf.length; i++) {
                    buf[i] = (byte) inputStream.read();
                    if (map.containsKey(buf[i])) {
                        map.replace(buf[i], map.get(buf[i]), map.get(buf[i]) + 1);
                    } else map.put(buf[i], 1);
                }
                for (Map.Entry<Byte, Integer> pair : map.entrySet())
                    if (pair.getValue() > this.max) {
                        this.max = pair.getValue();
                        this.maxbyte = pair.getKey();
                    }
                resultMap.put(this.fileName,(int)this.maxbyte);
               inputStream.close();

        } catch (IOException e) { }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
