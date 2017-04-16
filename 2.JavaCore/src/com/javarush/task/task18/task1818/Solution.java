package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String filename1=bufferedReader.readLine();
        String filename2=bufferedReader.readLine();
        String filename3=bufferedReader.readLine();
       /* BufferedReader file2=new BufferedReader(new FileReader(filename2));*/
        FileOutputStream file1=new FileOutputStream(filename2);
        FileInputStream file2=new FileInputStream(filename1);
        while (file2.available()>0){
            file1.write(file2.read());
            file1.flush();
        }
        file2.close();
        file1.close();
        bufferedReader.close();
        FileOutputStream fileW1=new FileOutputStream(filename1);
        FileInputStream file3=new FileInputStream(filename3);
        while (file3.available()>0){
            fileW1.write(file3.read());
        }


    }
}
