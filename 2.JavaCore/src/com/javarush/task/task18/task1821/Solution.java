package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] str = new int[256];
        while (fileInputStream.available() > 0) {
            str[fileInputStream.read()]++;
        }
        fileInputStream.close();
        for (int i = 0; i < 256; i++) {
            if (str[i] != 0) System.out.println((char)i+" "+str[i]);
        }
    }
}