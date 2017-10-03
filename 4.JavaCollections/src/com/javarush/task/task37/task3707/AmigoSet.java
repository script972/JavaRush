package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;
    public AmigoSet() {
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int)(collection.size()/0.75f +1)));
        this.addAll(collection);
    }
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();

    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        }
        catch (Exception e) {
            throw new InternalError();
        }
    }



   // Спасибо. Действительно валидатор требует поэлементную запись ключей и запись размера через writeInt
   //         (через writeObject почему-то не принимает, хотя результат сериализации от этого не зависит)


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        for (int i = 0; i < map.size(); i++) {
            out.writeObject(map.get(i));
        }
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
    }

    //В десериализации ключи в AmigoSet не добавляю, заполняю ими map.

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //defaultReadObject();
        in.defaultReadObject();

       /* * in.defaultReadObject();
        Set keys = (Set)in.readObject();
        float loadFactor = in.readFloat();
        int capacity = in.readInt();
        map = new HashMap(capacity, loadFactor);
        addAll(keys);
        * */
    }
}