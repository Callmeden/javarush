package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public int n=300;
    public int getCountOfEggsPerMonth() {
        return n;
    }
    public String getDescription() {
        return  super.getDescription()+" Моя страна - " +Country.BELARUS+". Я несу "+n+" яиц в месяц.";
    }
}
