package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1=new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2=new BufferedWriter(new FileWriter(args[1]));
       // BufferedReader file1=new BufferedReader(new FileReader("file.txt"));
       // BufferedWriter file2=new BufferedWriter(new FileWriter(args[1]));
        String ll=null;
        while (file1.ready()){
            String line=file1.readLine();
            String [] sep=line.split(" ");
            for (int i = 0; i < sep.length; i++) {
                if(sep[i].length()>6)
                    ll=ll+sep[i]+",";
            }
        }
        ll=ll.substring(4);
        ll=ll.substring(0, ll.length()-1);
        file2.write(ll);
      //  System.out.println(ll);
        file1.close();
       file2.close();

    }
}
