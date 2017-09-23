package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //Path passwords = downloadFile("http://placehold.it/100x50/88cc00.png", Paths.get("e:\\a.txt"));
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("E:/"));
        //Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("E:\\"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.substring(urlString.lastIndexOf("/")+1);

        Path resultFile = Paths.get(downloadDirectory + "/" + fileName);

        URL url = new URL(urlString);

        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-","");

        Files.copy(inputStream, tempFile);

        inputStream.close();

        Files.move(tempFile, resultFile);

        return resultFile;
    }
}