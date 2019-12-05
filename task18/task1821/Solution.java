package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
        byte[] buf = new byte[inputStream.available()];
        for(int i=0;i<buf.length;i++)
            buf[i]= (byte) inputStream.read();
        ArrayList<Byte> list = new ArrayList<>();
        for(int i=0;i<buf.length;i++)
            if(!list.contains(buf[i]))list.add(buf[i]);
        Collections.sort(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++)
            list2.add(0);
        for(int i=0;i<list.size();i++)
            for(int j=0;j<buf.length;j++)
                if(buf[j]==list.get(i)) list2.set(i,list2.get(i)+1);
        for(int i=0;i<list.size();i++){
            System.out.println((char)(byte) list.get(i)+" "+list2.get(i));
        }
        inputStream.close();
        /*HashMap<Byte,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++)
            map.putIfAbsent(list.get(i),0);
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))) map.replace(buf[i],map.get(buf[i]),map.get(buf[i])+1);
        }
        SortedMap<Byte,Integer> map2 = new SortedMap<Byte, Integer>() {
            @Override
            public Comparator<? super Byte> comparator() {
                return null;
            }

            @Override
            public SortedMap<Byte, Integer> subMap(Byte fromKey, Byte toKey) {
                return null;
            }

            @Override
            public SortedMap<Byte, Integer> headMap(Byte toKey) {
                return null;
            }

            @Override
            public SortedMap<Byte, Integer> tailMap(Byte fromKey) {
                return null;
            }

            @Override
            public Byte firstKey() {
                return null;
            }

            @Override
            public Byte lastKey() {
                return null;
            }

            @Override
            public Set<Byte> keySet() {
                return null;
            }

            @Override
            public Collection<Integer> values() {
                return null;
            }

            @Override
            public Set<Entry<Byte, Integer>> entrySet() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Integer get(Object key) {
                return null;
            }

            @Override
            public Integer put(Byte key, Integer value) {
                return null;
            }

            @Override
            public Integer remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends Byte, ? extends Integer> m) {

            }

            @Override
            public void clear() {

            }
        };
        map2.
        for(Map.Entry<Byte,Integer> pair: map.entrySet())
            System.out.println("--- "+pair);*/

    }
}
