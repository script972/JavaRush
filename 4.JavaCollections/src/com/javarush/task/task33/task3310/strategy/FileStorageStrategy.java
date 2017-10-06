package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 1000L;
    private int size;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    int hash(Long k) {
        return k.hashCode();
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    Entry getEntry(Long key) {
        if (size == 0)
            return null;
        int hash = key != null ? hash(key) : 0;
        FileBucket fileBucket = table[indexFor(hash, table.length)];
        for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k)))) {
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (FileBucket fb : table) {
            if (fb == null)
                continue;
            Entry e = fb.getEntry();
            while (null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                if (newTable[i] == null)
                    newTable[i] = new FileBucket();
                e.next = newTable[i].getEntry();
                newTable[i] = new FileBucket();
                newTable[i].putEntry(e);
                e = next;
            }
            fb.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
            hash = hash(key);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = key != null ? hash(key) : 0;
        int i = indexFor(hash, table.length);
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            if (fb != null) {
                for (Entry e = fb.getEntry(); e != null; e = e.next) {
                    if (e.getValue().equals(value))
                        return e.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key == null)
            return null;
        Entry e = getEntry(key);
        return e != null ? e.getValue() : null;
    }

   

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long l : keys) {
            result.add(shortener.getString(l));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> setValuesOriginal = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++)
            setValuesOriginal.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);
        Date start = new Date();
        Set<Long> setKeys = getIds(shortener, setValuesOriginal);
        Date end = new Date();
        long workTime = end.getTime() - start.getTime();
        Helper.printMessage(String.valueOf(workTime));
        start = new Date();
        Set<String> setValues = getStrings(shortener, setKeys);
        end = new Date();
        workTime = end.getTime() - start.getTime();
        Helper.printMessage(String.valueOf(workTime));
        boolean isContains = true;
        for (String str : setValues) {
            if (!setValuesOriginal.contains(str)) {
                Helper.printMessage("Тест не пройден.");
                isContains = false;
                break;
            }
        }
        if (isContains)
            Helper.printMessage("Тест пройден.");
    }
}