package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
       return this.values().size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if(!map.containsKey(key)){
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
            return null;
        }
        List<V> list = map.get(key);
        V lastValue = list.get(list.size()-1);

        if(list.size()>=repeatCount)
            list.remove(0);


        list.add(value);
        return lastValue;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if ( ! map.containsKey(key)) {
            return null;
        }

        V removedObject = null;
        List<V> valuesByKey = map.get(key);

        if (valuesByKey != null && valuesByKey.size() > 0) {
            removedObject = valuesByKey.get(0);
            valuesByKey.remove(0);
        }

        if (valuesByKey.isEmpty()) {
            map.remove(key);
        } else {
            map.put((K) key, valuesByKey);
        }

        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                map.remove(entry.getKey());
            }
        }

        return removedObject;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }


    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> list = new ArrayList<>();

        for(Entry<K,List<V>> entry:map.entrySet())
            list.addAll(entry.getValue());
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return this.values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}