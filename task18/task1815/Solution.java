package com.javarush.task.task18.task1815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface original;


        public TableInterfaceWrapper(TableInterface original) {
         this.original=original;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            original.setModel(rows);
        }

        @Override
        public String getHeaderText() {

            return original.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
             original.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}
