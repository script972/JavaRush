package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        A=A/0;
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int B = 5;
    public static void main(String[] args) {
        System.out.println(B);
    }
}
