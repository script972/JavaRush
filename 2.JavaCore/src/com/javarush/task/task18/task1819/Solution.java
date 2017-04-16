package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        try
        {
            FileInputStream inFile1 = new FileInputStream(fileName1);
            ArrayList<Integer> buffer = new ArrayList<>();
            while (inFile1.available() > 0)
            {
                buffer.add(inFile1.read());
            }
            inFile1.close();
            FileInputStream inFile2 = new FileInputStream(fileName2);
            FileOutputStream outFile1 = new FileOutputStream(fileName1);
            while (inFile2.available() > 0)
            {
                int data = inFile2.read();
                outFile1.write(data);
            }
            inFile2.close();
            for (int i = 0; i < buffer.size() ; i++)
            {
                outFile1.write(buffer.get(i));
            }
            outFile1.close();
        } catch (IOException e)
        {
        }
    }
}
