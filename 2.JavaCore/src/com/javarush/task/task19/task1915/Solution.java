package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution
{
    public static TestString testString = new TestString ( );

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String         nameF  = reader.readLine ( );
        //  nameF = "c://1";
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ( );
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream (outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut (stream);
        testString.printSomething ( );
        FileOutputStream fileWriter = new FileOutputStream (nameF);
        fileWriter.write (outputStream.toByteArray ( ));
        //Возвращаем все как было
        System.setOut (consoleStream);
        // дублируем в консоль
        System.out.print (outputStream.toString ( ));
        reader.close ( );
        fileWriter.close ( );
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println ("it's a text for testing");
        }
    }
}
