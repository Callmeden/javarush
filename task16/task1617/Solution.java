package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread thread = new Thread(clock);
        thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            Thread current = Thread.currentThread();
            while(!current.isInterrupted())
            {
                if(numSeconds==0) {System.out.println("Марш!"); break;}
               else System.out.print(numSeconds+" ");
                numSeconds--;
                try {
                    current.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Прервано!"); break;
                }
            }

        }
    }
}
