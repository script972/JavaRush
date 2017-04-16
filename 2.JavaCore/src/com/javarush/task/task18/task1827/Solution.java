package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            BufferedReader r = new BufferedReader(new FileReader(fileName));
            String line;
            long maxId = 0;
            while ((line = r.readLine()) != null) {
                list.add(line);
                line = line.substring(0, 8).replaceAll(" ", "");
                try {
                    long id = Integer.parseInt(line);
                    if (id > maxId) {
                        maxId = id;
                    }
                } catch (NumberFormatException e) {
                }
            }
            r.close();
            maxId++;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String s : list) {
                writer.write(s + "\r\n");
            }


            /*
            * fileWR.write(String.format("%-8.8s%-30.30s%-8.8s%-4.4s%n",String.valueOf(maxid),productname,args[args.length-2],args[args.length-1]));
                    fileWR.close();
            *
            * */
            String outputInformation = String.format(
                    "%-8d%-30s%-8s%-4s" + "\r\n", maxId, productName, price, quantity);
            writer.write(maxId+", "+productName+", "+ price+", "+ quantity);
            writer.close();
        }
    }
}