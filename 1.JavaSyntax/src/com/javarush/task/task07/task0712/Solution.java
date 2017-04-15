package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        List<String>lis=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            lis.add(br.readLine());
        }
        String min=lis.get(0);

        for (String s:
             lis) {
            if(min.length()<s.length())
                min=s;
        }
        System.out.println(min);
    }
}
