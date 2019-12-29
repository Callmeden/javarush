package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
       /* Integer[] array = new Integer[5];
        array[0]=13;
        array[1]=8;
        array[2]=15;
        array[3]=5;
        array[4]=17;
        sort(array);
        for(int i=0;i<5;i++)
            System.out.println(array[i]);*/ //для собственной проверки(валидатору это не надо)
    }

    public static Integer[] sort(Integer[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        Collections.sort(arrayList);        //упорядочиваем для нахождения медианы
        int mediana;
        if(arrayList.size()%2==1)              //если нечётное количество то медиана - это средний элемент
            mediana=arrayList.get(arrayList.size()/2);
        else
            mediana=(arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1))/2; // если чётное - то среднее арифм. двух средних
        Comparator<Integer> comparator = Comparator.comparingInt(o -> Math.abs(o - mediana));
        arrayList.sort(comparator);
        for(int i=0;i<arrayList.size();i++)
            array[i]=arrayList.get(i);
        return array;
    }
}
