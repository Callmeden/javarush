package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String grandpaName = reader.readLine();
         Cat catGrandpa = new Cat(grandpaName);
         String grandmaName = reader.readLine();
         Cat catGrandma = new Cat(grandmaName);
        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,null,catGrandpa);
        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,catGrandma,null);
        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName,catMother,catFather);
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother,catFather);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat ma;
        private Cat fa;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat ma, Cat fa) {
            this.name = name;
            this.ma = ma;
            this.fa = fa;
        }

        @Override
        public String toString() {
            if (ma == null&& fa == null)
                return "The cat's name is " + name + ", no mother, no father";
            else
                if (fa==null)
                return "The cat's name is " + name + ", mother is " + ma.name+", no father";
                else if (ma==null)
                    return "The cat's name is "+ name + ", no mother, father is " +fa.name;
                else return "The cat's name is " +name+ ", mother is "+ma.name+", father is " +fa.name;
        }
    }

}
