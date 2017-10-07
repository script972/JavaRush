package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){

        long time1=System.currentTimeMillis();
        for (String str :
                strings) {
            ids.add(shortener.getId(str));
        }
        return System.currentTimeMillis()-time1;

    }


    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){

        long time1=System.currentTimeMillis();
        for (Long id :
                ids) {
            strings.add(shortener.getString(id));
        }

        return System.currentTimeMillis()-time1;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1=new Shortener(new HashMapStorageStrategy());
        Shortener shortener2=new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings= new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long time1=getTimeForGettingIds(shortener1, origStrings, new HashSet<Long>());
        long time2=getTimeForGettingIds(shortener2, origStrings, new HashSet<Long>());
        Assert.assertTrue(time1>time2);

        /*time1=getTimeForGettingStrings(shortener1, origStrings, new HashSet<Long>());
        time2=getTimeForGettingStrings(shortener2, origStrings, new HashSet<Long>());*/
        Assert.assertTrue(time1>time2);

    }

    /*
    * Получать время получения идентификаторов для origStrings (вызывать метод
    * getTimeForGettingIds для shortener1, а затем для shortener2).
    *
    * */



}
