package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());
        if(a<0||b<0||c<0)
            System.out.println("Треугольник не существует.");
        if((a+b)>c && (b+c)>a && (a+c)>b)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
    }
}