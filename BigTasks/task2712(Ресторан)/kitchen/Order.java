package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
        ConsoleHelper.writeMessage(this.toString());
    }

    public int getTotalCookingTime(){
        int totalCookingTime=0;
        for(Dish dish:dishes)
            totalCookingTime+=dish.getDuration();
        return totalCookingTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        dishes= ConsoleHelper.getAllDishesForOrder();
    }


    @Override
    public String toString() {
        return dishes.isEmpty()?"":"Your order: "+dishes+" of "+tablet;
    }
}
