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
        String fileName=br.readLine();
        br.close();
        BufferedReader file=new BufferedReader(new FileReader(fileName));
        //BufferedReader file=new BufferedReader(new FileReader("file.txt"));
        String line=null;
        while (file.ready()){
            if(line==null)
                line= String.valueOf((char)file.read());
            else
                line=line+String.valueOf((char)file.read());
        }
        line=line.replaceAll("[^A-Za-z]", ",");
        String [] split=line.split(",");
        int counter=0;
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("world"))
                counter++;
        }
        System.out.println(counter);
        file.close();

    }
}


