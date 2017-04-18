package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=br.readLine();
        String fileName2=br.readLine();
        br.close();
        BufferedReader file1=new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2=new BufferedWriter(new FileWriter(fileName2));
        String line=null;
        while (file1.ready()){
            line=file1.readLine();
            file2.write(line.replaceAll("[\\p{Punct}\\n]",""));
        }
        file1.close();
        file2.close();

    }
}
