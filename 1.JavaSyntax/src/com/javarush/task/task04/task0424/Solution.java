package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numb = new int[3];
        numb[0] = Integer.parseInt(br.readLine());
        numb[1] = Integer.parseInt(br.readLine());
        numb[2] = Integer.parseInt(br.readLine());
        if (numb[0] != numb[1] && numb[0] != numb[2] && numb[1] != numb[2]) {

        } else {
            if (numb[0] != numb[1] && numb[0] != numb[2])
                System.out.println(1);
            else if (numb[1] != numb[0] && numb[1] != numb[2])
                System.out.println(2);
            else if (numb[2] != numb[0] && numb[2] != numb[1])
                System.out.println(3);
        }
    }
}
