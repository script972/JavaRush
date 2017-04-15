package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int col=0;
        while(fileIn.available()>0){
            if(fileIn.read()==44)
                col++;
        }
        System.out.println(col);
        fileIn.close();
    }
}
