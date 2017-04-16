package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map=new HashMap<>();
        map.put("Фамили1",300);
        map.put("Фамили2",400);
        map.put("Фамили3",500);
        map.put("Фамили4",600);
        map.put("Фамили5",700);
        map.put("Фамили6",800);
        map.put("Фамили7",900);
        map.put("Фамили9",1000);
        map.put("Фамили10",1100);
        map.put("Фамили11",1200);
        return  map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator iterator=map.entrySet().iterator();



        while (iterator.hasNext())
        {

            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) iterator.next();
            int value = pair.getValue();        //значение
            if (value < 500)
                iterator.remove();

        }

    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}