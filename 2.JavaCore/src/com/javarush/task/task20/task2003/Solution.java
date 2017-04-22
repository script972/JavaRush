package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<> ( );

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         file   = reader.readLine ( );
        reader.close ( );
        InputStream inputStream = new FileInputStream (file);
        load (inputStream);
        inputStream.close ( );
    }
    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter (outputStream));
        Properties property = new Properties ( );
        property.putAll (properties);
        property.store (bufferedWriter,"");
    }

    public void load(InputStream inputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties property = new Properties ( );
        property.load (inputStream);
        for (Map.Entry<Object, Object> pair : property.entrySet ( ))
        {
            properties.put (pair.getKey ( ).toString ( ), pair.getValue ( ).toString ( ));
        }
    }
    public static void main(String[] args) throws IOException
    {
    }
}