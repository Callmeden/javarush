package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop= new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);

       load(fileInputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        prop.putAll(properties);
        prop.store(outputStream, null);
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        prop.load(inputStream);
        for(String name:prop.stringPropertyNames())
            properties.put(name,prop.getProperty(name));
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
