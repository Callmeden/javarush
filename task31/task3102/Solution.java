package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootFile= new File(root);
        List<String> fileTree= new ArrayList<>();
        Queue<File> fileQueue=new PriorityQueue<>();

        Collections.addAll(fileQueue,rootFile.listFiles());

        while(!fileQueue.isEmpty()) {
            File file = fileQueue.remove();

            if(file.isDirectory())
                Collections.addAll(fileQueue,file.listFiles());
            else
                fileTree.add(file.getAbsolutePath());
        }

        return fileTree;
    }

    public static void main(String[] args) {
        
    }
}
