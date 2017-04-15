package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String f1=bufferedReader.readLine();
        String f2=bufferedReader.readLine();
        String f3=bufferedReader.readLine();
        FileInputStream file1 = new FileInputStream(f1);
        FileOutputStream file2 = new FileOutputStream(f2);
        FileOutputStream file3 = new FileOutputStream(f3);
        int tr=0;
        int count=file1.available();
        while(file1.available()>0){
            tr=file1.read();
            if(Math.ceil(count/2)<=file1.available())
            file2.write(tr);
            else
                file3.write(tr);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
