package com.javarush.task.task21.task2113;

import java.util.*;


public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for(int i=1;i<=100;i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse:horses)
            horse.move();
    }

    public void print(){
        for(Horse horse:horses)
            horse.print();
        for(int i=1;i<=10;i++)
            System.out.println();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner(){
        Horse winner=null;
        double max=0;
        for(Horse horse:horses)
            if(horse.getDistance()>max) {max=horse.getDistance();winner=horse;}
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!",getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("White",3,0);
        Horse horse2 = new Horse("Brown",3,0);
        Horse horse3 = new Horse("Black",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }
}
