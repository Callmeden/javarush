package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for(int i=1;i<args.length;i+=3) {
                        Date date =  new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[i+2]);
                        if(args[i+1].equals("м")) {
                            allPeople.add(Person.createMale(args[i],date));System.out.println(allPeople.size()-1);}
                        else if(args[i+1].equals("ж")){
                            allPeople.add(Person.createFemale(args[i],date));System.out.println(allPeople.size()-1);}}
                }
                break; }
            case "-u": {
                synchronized (allPeople) {
                    for(int i=1;i<args.length;i+=4) {
                        Date date =  new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[i+3]);
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setBirthDate(date);
                        allPeople.get(id).setName(args[i+1]);
                        if(args[i+2].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                        if(args[i+2].equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);}
                }
                break; }
            case "-d": {
                synchronized (allPeople) {
                    for(int i=1;i<args.length;i++){int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setBirthDate(null);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);}
                }
                break;}
            case "-i": {
                synchronized (allPeople) {
                    for(int i=1;i<args.length;i++){
                        int id = Integer.parseInt(args[i]);
                        Date date = allPeople.get(id).getBirthDate();
                        String name = allPeople.get(id).getName();
                        String sex = String.valueOf(allPeople.get(id).getSex());
                        if (sex.equals("MALE")) sex = "м";
                        else sex = "ж";
                        String dateString = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(date);
                        System.out.println(name+" "+sex+" "+dateString);}
                }
                break;
            }

        }
    }
}
