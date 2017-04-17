package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String filename1=bufferedReader.readLine();
        String filename2=bufferedReader.readLine();
        String filename3=bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fil2R=new FileInputStream(filename2);
        FileOutputStream file1W=new FileOutputStream(filename1);
        FileInputStream file3R=new FileInputStream(filename3);
        while (fil2R.available()>0){
            file1W.write(fil2R.read());
        }
        file1W=new FileOutputStream(filename1, true);
        while (file3R.available()>0){
            file1W.write(file3R.read());
        }
        fil2R.close();
        file1W.close();
        file3R.close();



    }
}
