package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file=new FileInputStream(br.readLine());
        int ln;
        int value;
        HashMap <Integer,Integer> map=new HashMap();
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
        Integer max = 0;
        for (Map.Entry ma :
                map.entrySet()) {
           if((Integer)ma.getValue()>max)
               max= (int) ma.getValue();
        }
        for (Map.Entry ma :
                map.entrySet()) {
            if(ma.getValue()==max)
                System.out.print(ma.getKey()+" ");
        }
        file.close();

    }
}
