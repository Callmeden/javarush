package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;

/*
Прайсы 2
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String s2 = "";

        try {
            if (args.length > 0) {
                s = reader.readLine();
                reader.close();

                String ID = args[1];
                int spacesNumber;
                if (ID.length() < 8)
                {
                    spacesNumber = 8 - ID.length();
                    for (int i = 0; i < spacesNumber; i++)
                        ID = ID + " ";
                }
                ArrayList<String> linesList = new ArrayList<>(); //список всех строк
                String newLine = "";

                //Получаем нужную строку
                BufferedReader fileReader = new BufferedReader(new FileReader(s));

                while (fileReader.ready()) {
                    s2 = fileReader.readLine();
                    if (s2.substring(0, 8).equals(ID)) {
                        newLine = newLine + s2;
                    }
                    linesList.add(s2);
                }
                fileReader.close();

                if (args[0].equals("-u")) {
                    //Обрезаем или заполняем пробелами параметры до нужного количества символов
                    newLine = newLine.substring(0, 8); //id

                    if (args[2].length() > 30) {
                        args[2] = args[2].substring(0, 30);
                    }
                    newLine = newLine + args[2]; //productName
                    if (args[2].length() < 30) {
                        spacesNumber = 30 - args[2].length();
                        for (int i = 0; i < spacesNumber; i++)
                            newLine = newLine + " ";
                    }

                    if (args[3].length() > 8) {
                        args[3] = args[3].substring(0, 8);
                    }
                    newLine = newLine + args[3]; //price
                    if (args[3].length() < 8) {
                        spacesNumber = 8 - args[3].length();
                        for (int i = 0; i < spacesNumber; i++)
                            newLine = newLine + " ";
                    }

                    if (args[4].length() > 4) {
                        args[4] = args[4].substring(0, 4);
                    }
                    newLine = newLine + args[4]; //quantity
                    if (args[4].length() < 4) {
                        spacesNumber = 4 - args[4].length();
                        for (int i = 0; i < spacesNumber; i++)
                            newLine = newLine + " ";
                    }

                    //Обновляем файл
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(s, false));
                    fileWriter.write("");
                    fileWriter.close();

                    BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(s, true));

                    for (int i = 0; i < linesList.size(); i++) {
                        if (!linesList.get(i).substring(0, 8).equals(newLine.substring(0, 8)))
                            fileWriter2.write(linesList.get(i) + "\n");
                        else {
                            fileWriter2.write(newLine + "\n");
                        }
                    }
                    fileWriter2.close();
                }

                if (args[0].equals("-d")) {
                    //Обновляем файл
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(s, false));
                    fileWriter.write("");
                    fileWriter.close();

                    BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(s, true));

                    for (int i = 0; i < linesList.size(); i++) {
                        if (!linesList.get(i).substring(0, 8).equals(newLine.substring(0, 8)))
                            fileWriter2.write(linesList.get(i) + "\n");
                    }
                    fileWriter2.close();
                }
            }
        }
        catch (FileNotFoundException e) {
        }
        catch (IOException e) {
        }
        catch (StringIndexOutOfBoundsException e) {
        }
        catch (NumberFormatException e) {

        }
    }
}


/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxid=0;
        reader.close();
        if(args.length!=0){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            String s;
            char[] c;
            String s1;
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNextLine()){
                s=scanner.nextLine();
                s1="";
                c=s.toCharArray();
                int j =0;
                while(c[j]!=' ' && j<8){
                    s1= s1+c[j];
                    j++;
                }
                if(Integer.parseInt(s1)>maxid) maxid=Integer.parseInt(s1); //maxid+1 - id которое нужно добавить
            }
            maxid=maxid+1;
            scanner.close();
            inputStream.close();
            String productName = args[1];
            char[] namechar = new char[30];
            for(int i=0;i<namechar.length;i++)
                if(i<productName.toCharArray().length)
                    namechar[i] =productName.toCharArray()[i];
                else namechar[i]=' ';
            //namechar[0-29] имя продукта
            String price = args[2];
            char[] pricechar = new char[8];
            for(int i=0;i<pricechar.length;i++)
                if(i<price.toCharArray().length)
                    pricechar[i] =price.toCharArray()[i];
                else pricechar[i]=' ';

            String quantity = args[3];
            char[] quantitychar = new char[4];
            for(int i=0;i<quantitychar.length;i++)
                if(i<quantity.toCharArray().length)
                    quantitychar[i] =quantity.toCharArray()[i];
                else quantitychar[i]=' ';
            //quantitychar[0-3] количество
            String result = String.valueOf(maxid);
            for(char ch: namechar)
                result= result+ch;
            for(char ch: pricechar)
                result= result+ch;
            for(char ch: quantitychar)
                result= result+ch;
            result="\n"+result;
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            out.write(result);
            out.close();
        }



        //outputStream.printf("%n%-8d%-30.30s%-8.2f%-4d", getNextId(filename), productName, price, quantity);
    }
}
*/