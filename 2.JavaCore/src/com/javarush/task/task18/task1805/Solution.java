package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file=new FileInputStream(br.readLine());
        ArrayList<Integer>list=new ArrayList<>();
        int l;
        while (file.available()>0){
            l=file.read();
            if(!list.contains(l)){
                list.add(l);
            }
        }
        Collections.sort(list);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        file.close();
    }
}
