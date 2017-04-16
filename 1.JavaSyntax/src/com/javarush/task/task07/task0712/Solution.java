package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list=new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(br.readLine());
        }
        //find min/max
        int min=list.get(0).length();
        int minIndex=0;
        int max=list.get(0).length();
        int maxIndex=0;

        for (int i = 0; i < list.size(); i++) {
            if(min>list.get(i).length()) {
                min = list.get(i).length();
                minIndex=i;
            }
            if(max<list.get(i).length()) {
                max = list.get(i).length();
                maxIndex=i;
            }
        }
        if(minIndex>maxIndex)
            System.out.println(list.get(maxIndex));
        else
        {
            System.out.println(list.get(minIndex));

        }


    }
}
