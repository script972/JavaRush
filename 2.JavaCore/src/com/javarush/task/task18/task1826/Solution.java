package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String type = args[0];
        BufferedReader file1 = new BufferedReader(new FileReader(args[1]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[2]));
        while (file1.ready()) {
            switch (type) {
                case "-e":file2.write(file1.read() + 2); break;
                case "-d":file2.write(file1.read() - 2); break;
            }
        }
        file1.close();
        file2.close();
    }

}
