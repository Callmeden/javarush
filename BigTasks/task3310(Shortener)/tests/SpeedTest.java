package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for(int i=0;i<10000;i++)
            origStrings.add(Helper.generateRandomString());
        HashSet<Long> longs = new HashSet<>();

        long time1 = getTimeToGetIds(shortener1,origStrings, longs);
        long time2 = getTimeToGetIds(shortener2,origStrings, new HashSet<>());

        Assert.assertTrue(time1>time2);

        time1 = getTimeToGetStrings(shortener1,longs,new HashSet<>());
        time2 = getTimeToGetStrings(shortener2,longs,new HashSet<>());

        Assert.assertEquals(time1,time2,30);
    }

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long beforeTest = new Date().getTime();

        for(String s:strings)
            ids.add(shortener.getId(s));

        return new Date().getTime() - beforeTest;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long beforeTest = new Date().getTime();

        for(Long id: ids)
            strings.add(shortener.getString(id));

        return new Date().getTime() - beforeTest;
    }
}
