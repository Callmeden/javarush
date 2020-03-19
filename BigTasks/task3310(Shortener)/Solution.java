package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.tests.FunctionalTest;
import com.javarush.task.task33.task3310.tests.SpeedTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
       /*
       Проверка работоспособности:
        testStrategy(new HashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new FileStorageStrategy(), 3);
        System.out.println("=========================================================================================");
            */

       //JUnit testing:
        FunctionalTest functionalTest = new FunctionalTest();
        functionalTest.testHashMapStorageStrategy();
        functionalTest.testOurHashMapStorageStrategy();
        functionalTest.testOurHashBiMapStorageStrategy();
        functionalTest.testHashBiMapStorageStrategy();
        functionalTest.testDualHashBidiMapStorageStrategy();
        functionalTest.testFileStorageStrategy();

        SpeedTest speedTest = new SpeedTest();
        speedTest.testHashMapStorage();
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for(String s:strings)
            set.add(shortener.getId(s));
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long l:keys)
            set.add(shortener.getString(l));
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        Shortener shortener = new Shortener(strategy);

        for(long i=0;i<elementsNumber;i++)
            strings.add(Helper.generateRandomString());

        long before = new Date().getTime();
        Set<Long> longs =getIds(shortener,strings);
        long interval = new Date().getTime() - before;
        Helper.printMessage(String.valueOf(interval));

        before = new Date().getTime();
        Set<String> resultStrings = getStrings(shortener, longs);
        interval = new Date().getTime() - before;
        Helper.printMessage(String.valueOf(interval));

        if (strings.equals(resultStrings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }


    }

}
