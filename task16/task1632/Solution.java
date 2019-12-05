package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        MyThread3 thread3 = new MyThread3();
        MyThread4 thread4 = new MyThread4();
        MyThread5 thread5 = new MyThread5();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }

    public static void main(String[] args) {


    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }

        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            try {
                MyThread2.currentThread().sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class MyThread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    MyThread3.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message {
        boolean b=true;
        @Override
        public void run() {
            while (b) {


            }

        }

        @Override
        public void showWarning() {
            b=false;

        }
    }

    public static class MyThread5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result;
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {

                    String tmp = reader.readLine();
                    if (tmp.equals("N")) {
                        System.out.println(result);
                        break;
                    }
                    result += Integer.parseInt(tmp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}