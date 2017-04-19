package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file1=new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2=new BufferedWriter(new FileWriter(args[1]));
     /*   BufferedReader file1=new BufferedReader(new FileReader("file.txt"));
        BufferedWriter file2=new BufferedWriter(new FileWriter("file2.txt"));*/

        while (file1.ready()){
            String [] world=file1.readLine().split(" ");
            for (int i = 0; i < world.length; i++) {
                if(world[i].contains("1") || world[i].contains("2") || world[i].contains("3") || world[i].contains("4") || world[i].contains("5") || world[i].contains("6") || world[i].contains("7") || world[i].contains("8") || world[i].contains("9") || world[i].contains("0")){
                    file2.write(world[i]+" ");
                    file2.flush();
                    continue;
                }
            }

        }
        file1.close();
        file2.close();
    }
}
