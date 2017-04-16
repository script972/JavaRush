package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(args[1]));
        switch (args[0]){
            case "-e":{
                byte[] result = encrypt(args[1], "qweqwe");
                BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(args[2]));
                for (byte b : result) {
                    writer.write(b);
                }
                writer.close();
                break;
            }
            case "-d":{
                byte[] readerResult = new byte[reader.available()];
                reader.read(readerResult);
                String result = decrypt(readerResult, "qweqwe");
                char[] fileName = result.toCharArray();
                BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(args[2]));
                for (char c : fileName) {
                    writer.write((int) c);
                }
                writer.close();
                break;
            }
        }

        reader.close();
    }

    public static byte[] encrypt(String text, String keyWord) {
        byte[] arr = text.getBytes();
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }

    public static String decrypt(byte[] text, String keyWord) {
        byte[] result = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (text[i] ^ keyarr[i % keyarr.length]);
        }
        return new String(result);

    }

}
