package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
        try{
            while(! Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);

            }
        }catch(Exception e){}
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this,threadName);
        thread.start();


    }


    @Override
    public void stop() {
            this.thread.interrupt();
    }
}
