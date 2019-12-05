package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] pers = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd M y", Locale.ENGLISH);
            String d = pers[3];
            String first = pers[1];
            String middleName = pers[2];
            String lastName = pers [0];
            Date date = null;
            try {
                date = dateFormat.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(first,middleName,lastName,date);
        }

        @Override
        public void close() throws IOException {
           fileScanner.close();
        }
    }
}
