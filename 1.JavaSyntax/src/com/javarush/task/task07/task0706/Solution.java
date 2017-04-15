package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int []number=new int[15];
        for (int i = 0; i < number.length; i++) {
            number[i]= Integer.parseInt(br.readLine());
        }
        int chet=0;
        int nechet=0;
        for (int i = 0; i < number.length; i++) {
            if(i%2==0 || i==0){
                chet+=number[i];
            }else
            {
                nechet+=number[i];
            }
        }
        if(chet<nechet)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else
            if(chet>nechet)
                System.out.println("В домах с четными номерами проживает больше жителей.");

    }
}
