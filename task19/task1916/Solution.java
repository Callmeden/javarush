package com.javarush.task.task19.task1916;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();//String s1,s2,s1next,s2next;
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        A.add(reader1.readLine());
        B.add(reader2.readLine());
        while(true){
            try {
                A.add(reader1.readLine());
                B.add(reader2.readLine());
                if(A.get(0).equals(B.get(0))){
                    lines.add(new LineItem(Type.SAME,A.get(0)));
                    A.remove(0);
                    B.remove(0);
                }
                else if(A.get(1).equals(B.get(0))) {
                    lines.add(new LineItem(Type.REMOVED,A.get(0)));
                    A.remove(0);
                }
                else if(A.get(0).equals(B.get(1))) {
                    lines.add(new LineItem(Type.ADDED,B.get(0)));
                    B.remove(0);
                }
            } catch (Exception e) {
                break;
            }

        }
        if (A.size()>=1)  for(String s:A) if(s!=null) lines.add(new LineItem(Type.REMOVED,s));
        while (reader1.ready()) lines.add(new LineItem(Type.REMOVED,reader1.readLine()));
        if (B.size()>=1) for(String s:B) if(s!=null) lines.add(new LineItem(Type.ADDED,s));
        while(reader2.ready()) lines.add(new LineItem(Type.ADDED,reader2.readLine()));
        reader1.close();
        reader2.close();
        for(LineItem l:lines)
            System.out.println(l.type+" "+l.line);
      /*  s1next=reader1.readLine();
        s2next=reader2.readLine();
        while(reader1.ready()&& reader2.ready()){
                s1=s1next;
                s2=s2next;

                if(s1.equals(s2)) {lines.add(new LineItem(Type.SAME,s1));s1next=reader1.readLine();s2next=reader2.readLine();}
                else if(s1.equals(s2next=reader2.readLine())) {
                    lines.add(new LineItem(Type.ADDED,s2));
                    lines.add(new LineItem(Type.SAME,s1));
                }
                else if(s2.equals(s1next=reader1.readLine())){
                    lines.add(new LineItem(Type.REMOVED,s1));
                    lines.add(new LineItem(Type.SAME,s2));
                }


        }
        if(s1next.equals(s2next)) lines.add(new LineItem(Type.SAME,s1next));
        if (reader1.ready()) lines.add(new LineItem(Type.REMOVED,reader1.readLine()));
        else if(reader2.ready()) lines.add(new LineItem(Type.ADDED,reader2.readLine()));
            reader1.close();
            reader2.close();
            for(LineItem l:lines)
                System.out.println(l.type+" "+l.line);
*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
