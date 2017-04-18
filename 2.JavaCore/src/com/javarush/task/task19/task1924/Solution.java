package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        reader.close();
        BufferedReader fileReader = new BufferedReader(fr);
        List<String[]> list = new ArrayList<>();
        while (fileReader.ready()) {
            String[] s = fileReader.readLine().split(" ");
            list.add(s);
        }
        fr.close();
        //fileReader.close();
        StringBuilder sb = new StringBuilder();
        for (String[] s : list) {
            for (int i = 0; i < s.length; i++) {
                try {
                    if (map.containsKey(Integer.parseInt(s[i]))) s[i] = map.get(Integer.parseInt(s[i]));
                }catch (NumberFormatException e) {}
            }
            for (String s1 : s) {
                sb.append(s1).append(" ");
            }
            if (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
