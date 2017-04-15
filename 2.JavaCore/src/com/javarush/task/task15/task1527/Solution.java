package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        String[] params = url.split("&");
        params[0] = params[0].split("\\?")[1];

        String name;
        List <String>list = new ArrayList<>();
        for (String s : params) {
            name = s.split("=")[0];
            if(name.equals("obj")){
                list.add(s.split("=")[1]);
                System.out.print(name + " ");
            }else{
                System.out.print(name + " ");
            }
        }
        System.out.println();
        for (String s : list) {
            try{
                double d = Double.parseDouble(s);
                alert(d);
            }catch (NumberFormatException e){
                alert(s);
            }
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
