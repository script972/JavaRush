package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        double t= Double.parseDouble(br.readLine());
        int count=0;
        int x = 0;
        while (count<t){
            count=count+3;
            if(count>t)
            {
                System.out.println("зелёный");
                break;
            }
            count=count+1;
            if(count>=t)
            {
                System.out.println("желтый");
                break;
            }
            count=count+1;
            if(count>=t)
            {
                System.out.println("красный");
                break;
            }

        }
    }
}