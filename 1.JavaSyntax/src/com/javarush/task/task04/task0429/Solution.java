package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int []n=new int[3];
        n[0]= Integer.parseInt(br.readLine());
        n[1]= Integer.parseInt(br.readLine());
        n[2]= Integer.parseInt(br.readLine());
        int p=0;
        int m=0;
        for (int i = 0; i < n.length; i++) {
            if(n[i]>0)
                p++;
            if(n[i]<0)
                m++;
        }
        System.out.println("количество отрицательных чисел: "+m);
        System.out.println("количество положительных чисел: "+p);

    }
}
