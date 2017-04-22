package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sys = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream arr = new PrintStream(outputStream);
        System.setOut(arr);
        testString.printSomething();
        String [] array = outputStream.toString().trim().split(" ");
        System.setOut(sys);
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);
        int c = 0;
        switch (array[1]) {
            case "+": {
                c = a + b;
                System.out.println(a + " " + array[1] + " " + b + " " + array[3] + " " + c);
                break;
            }
            case "*": {
                c = a * b;
                System.out.println(a + " " + array[1] + " " + b + " " + array[3] + " " + c);
                break;
            }
            case "-": {
                c = a - b;
                System.out.println(a + " " + array[1] + " " + b + " " + array[3]+" "+c);
    }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

