package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
     static {
         labels.put(3., "32");
         labels.put(4., "45");
         labels.put(5., "523");
         labels.put(6., "654");
         labels.put(7., "765");
     }

    public static void main(String[] args) {

        System.out.println(labels);
    }
}
