package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c": { Date date =  new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[3]);
                    if(args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1],date));System.out.println(allPeople.size()-1);}
                    else if(args[2].equals("ж")){
                        allPeople.add(Person.createFemale(args[1],date));System.out.println(allPeople.size()-1);}
                    break; }
            case "-u": { Date date =  new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[4]);
                         int id = Integer.parseInt(args[1]);
                         allPeople.get(id).setBirthDate(date);
                         allPeople.get(id).setName(args[2]);
                         if(args[3].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                         if(args[3].equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);
                         break; }
            case "-d": { int id = Integer.parseInt(args[1]);
                allPeople.get(id).setBirthDate(null);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                break;}
            case "-i": {
                int id = Integer.parseInt(args[1]);
                Date date = allPeople.get(id).getBirthDate();
                String name = allPeople.get(id).getName();
                String sex = String.valueOf(allPeople.get(id).getSex());
                if (sex.equals("MALE")) sex = "м";
                else sex = "ж";
                String dateString = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(date);
                System.out.println(name+" "+sex+" "+dateString);
            }

        }

    }
}
