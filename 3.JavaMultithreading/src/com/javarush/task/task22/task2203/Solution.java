package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null)
            throw new TooShortStringException();



        int counttab=0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='\t')
                counttab++;
        }

        if(counttab<2)
            throw new TooShortStringException();
        int indexSt=string.indexOf('\t');
        string=string.substring(1);
        int indexFn=string.indexOf('\t');
        if(indexFn==-1 || indexSt==-1 || indexFn==indexSt)
            throw new TooShortStringException();
        String newstr=string.substring(indexSt, indexFn);
        return newstr;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
