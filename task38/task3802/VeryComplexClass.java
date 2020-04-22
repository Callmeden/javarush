package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File notExistingFile = new File("D:\\NoSuchFile.txt");
        System.out.println(new FileReader(notExistingFile).read());
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
