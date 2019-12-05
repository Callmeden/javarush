package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public int n=400;
    public int getCountOfEggsPerMonth() {
        return n;
    }
    public String getDescription() {
        return  super.getDescription()+" Моя страна - " +Country.UKRAINE+". Я несу "+n+" яиц в месяц.";
    }
}
