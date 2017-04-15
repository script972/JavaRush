package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        if (n % 2 == 0 && n < 10 && n > 0)
        {
            System.out.println("четное однозначное число");
        }
        else if (n % 1 == 0 && n < 10 && n > 0)
        {
            System.out.println("нечетное однозначное число");
        }
        else if (n % 2 == 0 && n < 100 && n > 9)
        {
            System.out.println("четное двузначное число");
        }
        else if (n % 1 == 0 && n < 100 && n > 9)
        {
            System.out.println("нечетное двузначное число");
        }
        else if (n % 2 == 0 && n < 1000 && n > 99)
        {
            System.out.println("четное трехзначное число");
        }
        else if (n % 1 == 0 && n < 1000 && n > 99)
        {
            System.out.println("нечетное трехзначное число");
        }

    }
}
