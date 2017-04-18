package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader reader=new FileReader(br.readLine());
        String text=null;
        while (reader.ready()){
            text=text+(char)reader.read();
        }
        System.out.println(text.split(" world ").length+1);
        reader.close();
        br.close();

    }
}
