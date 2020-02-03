package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
            return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderedDishes =new ArrayList<>();
        writeMessage("Выберите блюдо. Для завершения заказа введите exit");
        writeMessage(Dish.allDishesToString());
        String s = readString();
        while(!s.equals("exit")){
            if(!Dish.contains(s)) {
            writeMessage("Нет такого блюда.");
            s=readString();
            }
            else {
                orderedDishes.add(Dish.valueOf(s));
                s=readString();
            }
        }
        return orderedDishes;
    }
}
