package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine(); // E:/Temp/in.txt
        String goodID = args[0];


        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        boolean isFind = false;
        String goodString = reader.readLine();
        while ( (goodString != null && goodString.length() > 0) && !isFind ) {
            String[] values = goodString.split(" ");
            if (values.length > 0) {
                String id = values[0];
                if ( id.equals(goodID) ) {
                    isFind = true;
                    System.out.println(goodString);
                }
            }
            goodString = reader.readLine();
        }
        console.close();
        reader.close();
    }
}