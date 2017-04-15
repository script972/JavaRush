package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String ss=br.readLine();
        switch (ss){
            case "helicopter": result=new Helicopter(); break;
            case "plane": result=new Plane(330);
        }
        br.close();
        //add your code here - добавьте код тут
    }
}
