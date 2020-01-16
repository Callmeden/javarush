package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger priority= new AtomicInteger(1);
    public MyThread() {
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if(priority.get()>MAX_PRIORITY || priority.get()>Thread.currentThread().getThreadGroup().getMaxPriority())
            priority.set(1);
        setPriority(priority.getAndIncrement());
    }
}
