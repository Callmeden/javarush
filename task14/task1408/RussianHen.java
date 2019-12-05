package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public int n=500;
    public int getCountOfEggsPerMonth() {
        return n;
    }
    public String getDescription() {
        return  super.getDescription()+" Моя страна - " +Country.RUSSIA+". Я несу "+n+" яиц в месяц.";
    }
}
