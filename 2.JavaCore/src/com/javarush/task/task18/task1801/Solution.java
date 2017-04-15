package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        FileInputStream file=new FileInputStream(line);
        int max=0;
        int l;
        while (file.available()>0){
            l=file.read();
            if(max<l){
                max=l;
            }
        }
        System.out.println(max);
        file.close();
    }
}
