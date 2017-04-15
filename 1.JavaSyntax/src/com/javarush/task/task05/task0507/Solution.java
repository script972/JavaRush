package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        double count=0;
        double number=0;
        double n=0;
        while (true){
            n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            number = number + n;
            count++;
        }
        System.out.println((double) number/count);
    }
}

