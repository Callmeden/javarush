package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<>();
    }
//Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }
    public static class StringObject<Object> implements SimpleObject<String> {

        @Override
        public SimpleObject<String> getInstance() {

            return this;}
    }

}
