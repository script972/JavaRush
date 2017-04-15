package com.javarush.task.task18.task1802;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream file=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int l;
        int min=file.read();
        while (file.available()>0){
            l=file.read();
            if(l<min){
                min=l;
            }
        }
        System.out.println(min);
        file.close();
    }
}
