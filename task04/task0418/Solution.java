package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = reader.readLine();
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(s2);
        if (a < b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }

    }
}