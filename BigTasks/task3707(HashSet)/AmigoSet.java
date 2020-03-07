package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object(); //заглушка
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        int capacity = (int) Math.max(16,collection.size()/.75f+1);
        map = new HashMap<>(capacity);
        for(E e:collection)
            map.put(e,PRESENT);
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        Set<E> keySet = map.keySet();
        Object[] array = keySet.toArray();
        outputStream.writeObject(array);

        Object loadFactor= HashMapReflectionHelper.callHiddenMethod(map,"loadFactor");
        outputStream.writeObject(loadFactor);

        Object capacity = HashMapReflectionHelper.callHiddenMethod(map,"capacity");
        outputStream.writeObject(capacity);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        Object[] keys = (Object[]) inputStream.readObject();
        float loadFactor = (float) inputStream.readObject();
        int capacity = (int) inputStream.readObject();

        map = new HashMap<>(capacity,loadFactor);

        for(Object object:keys)
            map.put((E)object,PRESENT);
    }

    @Override
    public Object clone(){
        try {
            AmigoSet<E> clone = (AmigoSet<E>) super.clone();
            clone.map = (HashMap<E, Object>) map.clone();
            return clone;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean add(E e) {
        return map.put(e,PRESENT)==null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==o;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }
}
