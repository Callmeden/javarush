package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException, InterruptedException {

       ReadFileThread readFileThread1 = new ReadFileThread();
       ReadFileThread readFileThread2 = new ReadFileThread();
       readFileThread1.start();
       readFileThread2.start();
       readFileThread1.join();
       readFileThread2.join();
       allLines.addAll(readFileThread1.getList());
       forRemoveLines.addAll(readFileThread2.getList());
        /*System.out.println(allLines);
        System.out.println(forRemoveLines);*/
        readFileThread1.interrupt();
        readFileThread2.interrupt();
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        /*System.out.println(allLines);
        System.out.println(forRemoveLines);*/
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new  CorruptedDataException();
        }
                  }

    public static class ReadFileThread extends Thread {
        private FileInputStream fileInputStream;
        private Scanner scanner;
        private BufferedReader reader;
        private ArrayList<String> list;
         public void run() {
             this.reader = new BufferedReader(new InputStreamReader(System.in));
             try {
                 this.fileInputStream = new FileInputStream(reader.readLine());
             } catch (IOException e) {
                 e.printStackTrace();
             }
             this.list = new ArrayList<>();
             this.scanner = new Scanner(fileInputStream);
             while(this.scanner.hasNextLine())
                 this.list.add(this.scanner.nextLine());
        }
        public ArrayList<String> getList(){
             return this.list;
        }

        }
}