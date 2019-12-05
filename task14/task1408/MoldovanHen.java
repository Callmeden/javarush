package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    public int n=200;
    public int getCountOfEggsPerMonth() {
        return n;
    }
    public String getDescription() {
        return  super.getDescription()+" Моя страна - " +Country.MOLDOVA+". Я несу "+n+" яиц в месяц.";
    }
}
