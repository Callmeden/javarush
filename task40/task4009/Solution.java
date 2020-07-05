package com.javarush.task.task40.task4009;

/* 
Buon Compleanno!
*/

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        LocalDate birthdayDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy"));

        LocalDate requiredYearBirthday = birthdayDate.withYear(Year.parse(year).getValue());

        return requiredYearBirthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
