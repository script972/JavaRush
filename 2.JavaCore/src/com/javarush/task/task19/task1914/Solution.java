package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        int result = 0;
        char a = outputStream.toString().charAt(2);
        if(a=='+')
        {
            result = Character.getNumericValue(outputStream.toString().charAt(0)) + Character.getNumericValue(outputStream.toString().charAt(4));
            System.out.print(outputStream.toString()+result);
        }
        if(a=='-')
        {
            result = Character.getNumericValue(outputStream.toString().charAt(0)) - Character.getNumericValue(outputStream.toString().charAt(4));
            System.out.print(outputStream.toString()+result);
        }
        if(a=='*')
        {
            result = Character.getNumericValue(outputStream.toString().charAt(0)) * Character.getNumericValue(outputStream.toString().charAt(4));
            System.out.print(outputStream.toString()+result);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

