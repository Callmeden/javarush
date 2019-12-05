package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws  MyException3 {
        try {
            int i = (int) (Math.random() * 4);
            if (i == 0) {
                throw new MyException();
            } else if (i == 1) {
                throw new MyException2();
            } else if (i == 2) {
                throw new MyException3();
            } else if (i==3) {
                throw new MyException4();
            }
        } catch (MyException e) {
            System.out.println(e);
        } catch (MyException3 e) {
            System.out.println(e);
        }

    }
    
    static class MyException extends IOException {
    }

    static class MyException2 extends MyException {


    }

    static class MyException3 extends RuntimeException {
    }

    static class MyException4 extends MyException3  {
    }
}

