package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;
    public Circle(double x)
    {
        this.x=x;
    }
    public Circle(double x, double y){
        this.x=x;
        this.y=y;
    }
    public Circle(double x,double y,double radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    public Circle(Circle circle){
        this.x=circle.x;
        this.y=circle.y;
        this.radius=circle.radius;
    }
    public Circle() {this(10,5,10);}

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}