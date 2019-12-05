package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
      double t = Double.parseDouble(s);
      double ost = t%5;
      if (ost<3) System.out.println("зелёный");
      else if(ost<4) System.out.println("жёлтый");
      else System.out.println("красный");

    }
}