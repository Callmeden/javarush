package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1=new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {

                    }
                }
            }
        };

            Thread thread2=new Thread(){
                @Override
                public void run() {
                    solution.someMethodWithSynchronizedBlocks(o1,o2);
                }
            };
            thread1.start();
            thread2.start();
            Thread.sleep(2000);
            return (thread2.getState()!= Thread.State.BLOCKED);
            /*
            Логика такова. Мы специально создаем дедлок. Если в даном нам методе синхронизация происходит сначала по 1 объекту,
             потом по 2, значит дедлока не будет и наш метод просто подождет немного и выполнится, иначе образуется дедлок и
             вторая нить станет BLOCKED.
             */
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
