package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new TreeSet<>();
        String s;
        while (reader.ready()) {
            s = reader.readLine();
            if (s.equals("end"))
                break;
            set.add(s);
        }
        Iterator iterator = set.iterator();
        String folder = (String) iterator.next();
        folder = folder.substring(0, folder.lastIndexOf("."));
        FileOutputStream outputStream = new FileOutputStream(folder);
        for (String s1 : set) {
            FileInputStream inputStream = new FileInputStream(s1);
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }
        outputStream.close();
    }
}
