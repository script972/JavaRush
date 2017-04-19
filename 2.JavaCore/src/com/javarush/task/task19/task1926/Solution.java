package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file=new BufferedReader(new FileReader(br.readLine()));
       // BufferedReader file=new BufferedReader(new FileReader("file.txt"));
        br.close();
        while (file.ready()){
            String line=file.readLine();
            String perev=null;
            for (int i = line.length()-1; i >= 0; i--) {
                if(perev==null){
                    perev= String.valueOf(line.charAt(i));
                } else {
                    perev = perev + line.charAt(i);
                }
            }
            System.out.println(perev);
        }
        file.close();
    }

}
