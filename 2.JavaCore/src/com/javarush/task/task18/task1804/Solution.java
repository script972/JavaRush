package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream file=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int ln;
        int value;
        HashMap<Integer,Integer> map=new HashMap();
        while (file.available()>0){
            ln=file.read();
            if(!map.containsKey(ln)) {
                map.put(ln, 0);
            }else
            {
                value=map.get(ln);
                value++;
                map.put(ln,value);
            }
        }
        Integer min = 10000;
        for (Map.Entry ma :
                map.entrySet()) {
            if((Integer)ma.getValue()<min)
                min= (int) ma.getValue();
        }
        for (Map.Entry ma :
                map.entrySet()) {
            if(ma.getValue()==min)
                System.out.print(ma.getKey()+" ");
        }
        file.close();
    }
}
