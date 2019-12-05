package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String ss = reader.readLine();
            if (ss.isEmpty()) {
                break;
            }
            list.add(ss);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> qn = new ArrayList<>();// порядковые номера чисел в списке
        ArrayList<Integer>  qs = new ArrayList<>();//порядковые номера строк в списке
        ArrayList<String> s = new ArrayList<>(); //строки из списка
        ArrayList<Integer> numbers = new ArrayList<>();//числа из списка
        for(int i=0;i<array.length;i++) {
            if (isNumber(array[i])) {qn.add(i);numbers.add(Integer.valueOf(array[i])); }
            else {qs.add(i);s.add(array[i]);}
        } //заполнили четыре списка
         {
            int a;
            for (int i = 0;i<numbers.size();i++) {
                for (int j = 1; j < numbers.size(); j++)
                    if(numbers.get(j)>numbers.get(j-1))
                    {
                        a=numbers.get(j);
                        numbers.set(j,numbers.get(j-1));
                        numbers.set(j-1,a);
                    }
            }
        } //рассортировали числа в списке по убыванию
         {
            String x1;
            for(int i=0;i<s.size();i++)
             for(int j=1;j<s.size();j++)
                if(isGreaterThan(s.get(j-1),s.get(j))){
                x1=s.get(j-1);
                s.set(j-1,s.get(j));
                s.set(j,x1);
                }
        }// рассортировали строки в списке по возрастанию
        {for(int i=0;i<qn.size();i++)
                array[qn.get(i)]=numbers.get(i).toString();}//вставляем рассортированные числа из списка в массив уже на свои места
        {for(int i=0;i<qs.size();i++)
                array[qs.get(i)]=s.get(i);}//вставляем рассортированные строки из списка в массив уже на свои места
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
