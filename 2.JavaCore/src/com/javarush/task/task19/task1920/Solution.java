package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file=new BufferedReader(new FileReader(args[0]));

        //BufferedReader file=new BufferedReader(new FileReader("file.txt"));
        Map<String, Double> map=new HashMap<>();
        String line=null;
        while (file.ready()){
            line=file.readLine();
            String[]str=line.split(" ");
          //  System.out.println("key="+str[0]+" value="+str[1]);
            if(!map.containsKey(str[0])){
                map.put(str[0], Double.valueOf(str[1]));
            } else{
                double value=map.get(str[0]);
                map.put(str[0], Double.valueOf(str[1])+value);
            }
        }


        double max=Double.MIN_VALUE;
        String value = null;

        for (Map.Entry<String, Double> ob:
                map.entrySet()){
            if(ob.getValue()>max) {
                max = ob.getValue();
                value=ob.getKey();
            }
        }

        for (Map.Entry<String, Double> ob:
                map.entrySet()){
            if(ob.getValue()==max) {
                System.out.println(ob.getKey());

            }
        }
        file.close();

    }
}
