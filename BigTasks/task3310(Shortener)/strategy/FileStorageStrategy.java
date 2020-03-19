package com.javarush.task.task33.task3310.strategy;

import java.util.Objects;

public class FileStorageStrategy implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT=10000L;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize;



    public int hash(Long k){
        return Objects.hashCode(k);
    }

    public int indexFor(int hash, int length){
        return (length - 1) & hash;
    }

    public Entry getEntry(Long key){
        int hash = hash(key);
        FileBucket bucket = table[indexFor(hash,table.length)];

        for(Entry e = bucket.getEntry(); e!= null; e = e.next){
            if(e.hash == hash && e.key.equals(key))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;

        for(FileBucket bucket:table){
            bucket.remove();
        }
    }

    public void transfer(FileBucket[] newTable){
        FileBucket[] src = table;
        int newCapacity = newTable.length;

        for(int i=0; i<src.length; i++){
            FileBucket bucket = src[i];
            Entry e = bucket.getEntry();

            if(e!=null){
                src[i] =null;

                do{
                    int index = indexFor(e.hash, newCapacity);
                    FileBucket newTableBucket;
                    if(newTable[index]==null){
                        newTableBucket = new FileBucket();
                        newTable[index] = newTableBucket;
                    } else{
                      newTableBucket = newTable[index];
                    }

                    e.next = newTableBucket.getEntry();
                    newTableBucket.putEntry(e);

                    e = e.next;
                }
                while(e!=null);

            }

        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){
        createEntry(hash,key,value,bucketIndex);

        FileBucket bucket = table[bucketIndex];

        if(bucket.getFileSize() > bucketSizeLimit)
            resize(table.length * 2);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket bucket = table[bucketIndex];
        if(bucket == null){
            bucket = new FileBucket();
            table[bucketIndex] =bucket;
        }

        bucket.putEntry(new Entry(hash,key,value,bucket.getEntry()));
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key)!=null;
    }

    @Override
    public boolean containsValue(String value) {
        for (FileBucket bucket : table) {
            if (bucket == null)
                continue;

            for (Entry e = bucket.getEntry(); e != null; e = e.next)
                if (e.getValue().equals(value))
                    return true;
        }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, this.table.length);

        FileBucket bucket = table[index];
        if(bucket==null){
            bucket = new FileBucket();
            table[index] = bucket;
        }

        for (Entry e = bucket.getEntry(); e != null; e = e.next) {

            if (e.hash == hash && e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket currentBucket : this.table) {
            if (currentBucket == null)
                continue;

            for (Entry e = currentBucket.getEntry(); e != null; e = e.next) {
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
