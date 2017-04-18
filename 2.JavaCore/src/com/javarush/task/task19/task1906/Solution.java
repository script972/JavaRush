package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {

    public static void main(String[] args) throws Exception
    {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String file1=read.readLine();
        String file2=read.readLine();
        read.close();
        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            reader.read();
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write((byte)data); //пишем один символ (int будет обрезан/сужен до char)
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
