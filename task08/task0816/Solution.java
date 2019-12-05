package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлон", dateFormat.parse("MARCH 1 2012"));
        map.put("Сталле", dateFormat.parse("APRIL 1 2012"));
        map.put("Сталоне", dateFormat.parse("JUNE 1 2012"));
        map.put("Саллоне", dateFormat.parse("JULY 1 2012"));
        map.put("Стллоне", dateFormat.parse("MAY 1 2012"));
        map.put("Стлоне", dateFormat.parse("MAY 1 2012"));
        map.put("таллоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталло", dateFormat.parse("MAY 1 2012"));
        map.put(" Сталло", dateFormat.parse("AUGUST 1 2012"));

       return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.entrySet().removeIf(pair -> pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8);




    }

    public static void main(String[] args) throws ParseException {


    }
}
