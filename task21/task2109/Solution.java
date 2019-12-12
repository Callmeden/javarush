package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        @Override
        protected B clone() throws CloneNotSupportedException {
            if (!(this.getClass()== B.class))  return (B) super.clone();
            else throw new CloneNotSupportedException();
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        @Override
        protected B clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }

    public static void main(String[] args) {

    }
}
