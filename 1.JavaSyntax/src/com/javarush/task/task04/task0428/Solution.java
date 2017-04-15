package com.javarush.task.task04.task0428;

/* 
Положительное число
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
        int c=0;
        for (int i = 0; i < n.length; i++) {
            if(n[i]>0)
                c++;
        }
        System.out.println(c);

    }
}
