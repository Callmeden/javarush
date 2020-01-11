package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        synchronized (mail) {
            long startTime = System.currentTimeMillis();
            while(mail.getText()==null) {
                try {
                    mail.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mail.notify();
            //сделайте что-то тут - do something here
            String name = Thread.currentThread().getName();
            long endTime = System.currentTimeMillis();
            System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
        }
    }
}