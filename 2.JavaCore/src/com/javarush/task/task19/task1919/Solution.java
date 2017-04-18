package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map=new TreeMap<>();
        while (file.ready()){
            String line=file.readLine();
            String []text=line.split(" ");
            if(map.containsKey(text[0])){
                double value=map.get(text[0]);
                map.put(text[0], Double.valueOf(text[1])+value);
            }else{
                map.put(text[0], Double.valueOf(text[1]));
            }
        }
        for (Map.Entry<String, Double> next:
                map.entrySet()){
            System.out.println(next.getKey()+" "+next.getValue());
        }
        file.close();

    }
}
