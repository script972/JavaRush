package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName — путь к файлу;
2) number — число, позиция в файле;
3) text — текст.
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            byte[] buf = new byte[text.length()];
            file.seek(number);
            file.read(buf, 0, buf.length);
            String lineFromFile = convertByteToString(buf);
            String storeToFile = lineFromFile.equals(text) ? "true" : "false";
            file.seek(file.length());
            file.write(storeToFile.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String convertByteToString (byte readBytes[]) {
        //return new String(readBytes, StandardCharsets.UTF_8);
        return new String(readBytes);
    }
}
