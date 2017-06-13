package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream("lol1.txt"));

        Solution savedObject=new Solution(12);
        outputStream.writeObject(savedObject);

        Solution readObject;
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("lol1.txt"));
        readObject= (Solution) objectInputStream.readObject();

        if(readObject.string==savedObject.string){
            System.out.println("equals");
        } else{
            System.out.println("not equals");
        }

        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
