package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true){
            line=scanner.readLine();
            if(line.equals("exit"))
                break;
            if(line.contains("."))
                print((Double) Double.parseDouble(line)); else
            if(Double.parseDouble(line)>0 && Double.parseDouble(line)<128)
                print((short)Short.parseShort(line)); else
            if(Double.parseDouble(line)>0 ||Double.parseDouble(line)>=128)
                print(Integer.parseInt(line));else
                    print((String) line);


        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
