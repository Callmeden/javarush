package com.javarush.task.task33.task3310.strategy;

import java.util.Objects;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k){
        return Objects.hashCode(k);
    }

    public int indexFor(int hash, int length){
        return (length - 1) & hash;
    }

    public Entry getEntry(Long key){
        for(Entry e = table[indexFor(hash(key),table.length)]; e!= null; e = e.next){
            if(e.hash == hash(key) && e.key.equals(key))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    public void transfer(Entry[] newTable){
        Entry[] src = table;
        int newCapacity = newTable.length;

        for(int i=0; i<src.length; i++){
            Entry e = src[i];

            if(e!=null){
                src[i] =null;

                do{
                    int index = indexFor(e.hash, newCapacity);
                    e.next = newTable[index];
                    newTable[index] = e;
                    e = e.next;
                }
                while(e!=null);

            }

        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash,key,value,e);

        if(size++ == threshold)
            resize(table.length * 2);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash,key,value,e);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < this.table.length; i++) {
            for (Entry entry = this.table[i]; entry != null; entry = entry.next) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, this.table.length);

        for (Entry e = this.table[index]; e != null; e = e.next) {

            if (e.hash == hash && e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : this.table) {
            for (Entry e = entry; e != null; e = e.next) {
                if (e.getValue().equals(value)) {
                    return e.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).value;
    }
}
