package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine();
      int a = Integer.parseInt(s);
      String vis = "количество дней в году: 366";
      String ob = "количество дней в году: 365";
      if (check(a,400)== true) System.out.println(vis);
      else if (check(a,100)== true) System.out.println(ob);
      else if (check(a, 4)== true) System.out.println(vis);
      else System.out.println(ob);
          }
    private static boolean check (int x,int multiplier)
    {
        int y = x/multiplier;
        if ((y*multiplier)==x) return true;
        else return false;
    }
}
