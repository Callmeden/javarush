package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance;
     Sun(){}
    public static Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }

}
