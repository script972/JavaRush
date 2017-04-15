package com.javarush.task.task17.task1721;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String filename1=br.readLine();
        String filename2=br.readLine();
        br.close();
        BufferedReader file=new BufferedReader(new FileReader(filename1));
        while(file.ready()){
            allLines.add(file.readLine());
        }
        file=new BufferedReader(new FileReader(filename2));
        while (file.ready()){
            forRemoveLines.add(file.readLine());
        }
        file.close();
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e){
            System.out.println(e);
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
