package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        int[] n = new int[33];
        for(int i=0;i<n.length;i++)
            n[i]=0;

        for(int i= 0; i<10;i++){
            for(int j=0;j<list.get(i).toCharArray().length;j++)
              for(int k=0;k<33;k++)
                if(list.get(i).toCharArray()[j]==alphabet.get(k)) {n[k]=n[k]+1; }

        }
        for (int i=0;i<33;i++)
            System.out.println(alphabet.get(i)+" "+n[i]);
    }
}
