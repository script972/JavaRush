package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] s = fileScanner .nextLine().split(" ");
            Person person=new Person(s[0], s[1], s[2], new Date(s[3]+" "+s[4]+" "+s[5]));
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
