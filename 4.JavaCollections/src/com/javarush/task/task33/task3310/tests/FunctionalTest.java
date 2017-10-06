package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String str1="lalala";
        String str2="bababa";
        String str3="lalala";
        long id1=shortener.getId(str1);
        long id2=shortener.getId(str2);
        long id3=shortener.getId(str3);


        String res1=shortener.getString(id1);
        String res2=shortener.getString(id2);
        String res3=shortener.getString(id3);

        Assert.assertNotEquals(res1, res2, res3);
        Assert.assertEquals(res1, res3);


        Assert.assertEquals(res1, str1);
        Assert.assertEquals(res2, str2);
        Assert.assertEquals(res3, str3);

    }

    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);

    }

    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy strategy1 = new OurHashMapStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);

    }

    @Test
    public void testFileStorageStrategy(){
        StorageStrategy strategy1 = new FileStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy strategy1 = new HashBiMapStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy strategy1 = new DualHashBidiMapStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy strategy1 = new OurHashBiMapStorageStrategy();
        Shortener shortener=new Shortener(strategy1);
        testStorage(shortener);
    }
}
