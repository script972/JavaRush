package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String ss;
    int s1;
    short s2;
    double s3;



    private Solution(String ss) {
        this.ss = ss;
    }
    protected Solution(int s1) {
        this.s1 = s1;
    }
    Solution(short s2) {
        this.s2 = s2;
    }
    public Solution(double s3) {
        this.s3 = s3;
    }

    public static void main(String[] args) {

    }


}

