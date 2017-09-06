package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null)
            throw new TooShortStringException();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if(Character.toString(string.charAt(i)).equals(" ")){
                count++;
            }
        }
        if (count < 4) {
            throw new TooShortStringException();
        } else {
            String s[] = string.split(" ");
            String s1 = s[1] + " " + s[2] + " " + s[3] + " " + s[4];
            return s1;
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
