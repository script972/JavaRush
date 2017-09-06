package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
      //  getTokens("один.два.три.четыри.пять", ".");
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer=new StringTokenizer(query, delimiter);
        String []str=new String[stringTokenizer.countTokens()];
        int i=0;
        while (stringTokenizer.hasMoreElements()){
            str[i]=stringTokenizer.nextToken();
            i++;
        }

     /*   for (int j = 0; j < str.length; j++) {
            System.out.println(str[j]);
        }*/
        return str;
    }
}
