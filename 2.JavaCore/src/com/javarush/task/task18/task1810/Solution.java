package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        FileInputStream fileInputStream = null;
        String red;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            red = buf.readLine();
            fileInputStream = new FileInputStream(red);
            if (fileInputStream.available() < 1000 || red.isEmpty()){
                fileInputStream.close();
                throw new DownloadException();

            }
        }
    }



    public static class DownloadException extends Exception {

    }
}
