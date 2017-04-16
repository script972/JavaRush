package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String filename=bufferedReader.readLine();
            try {
                FileReader fileReader = new FileReader(new File(filename));
                fileReader.close();
            } catch (FileNotFoundException e){
                System.out.println(filename);
                break;
            }
        }
        bufferedReader.close();


    }
}
