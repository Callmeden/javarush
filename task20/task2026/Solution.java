package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }
    public static int count;    //счётчик прямоугольников
    public static int getRectangleCount(byte[][] a) {
        count =0;       //обнуляем счётчик
        setRectangleCount(a); //т.к. getRectangleCount у нас не void, то придётся создать свой метод для рекурсии
        return count;
    }
    public static void setRectangleCount(byte[][]a){
        boolean b=false; //false - значит что до этого шёл ноль, true - единица(другими словами - найден ли прямоугольник)
        int imax=-1,jmax=-1,imin=-1,jmin=-1;    //координаты углов прямоугольника
        for(int i=0;i<a.length&&!b;i++)//в условии !b стоит потому что нет смысла продолжать поиск если уже нашёлся прямоугольник
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1 && !b) {         //нашли единицу, надо проверить, это первая или очередная.
                        b = true;
                        imin = i;               //координаты верхнего левого угла прямоугольника
                        jmin = j;
                    }
                else if(a[i][j]==0 && b) {
                    jmax= j-1;
                    break;}       // нашли правую границу прямоугольника
            }
        if (b) {              //ищем нижнюю границу прямоугольника
            count++;            //увеличиваем счётчик т.к. нашли прямоугольник
            if (jmax==-1) jmax=a.length-1; //если правая граница прямоугольника совпадает с границей массива
            for (int i = imin; i < a.length; i++)       //находим нижнюю границу прямоугольника
                if (a[i][jmin] == 0) {
                    imax = i - 1;
                    break;
                }
            if (imax==-1) imax= a.length-1; //если нижняя граница прямоугольника совпадает с границей массива
            for(int i=imin;i<=imax;i++)
                for(int j=jmin;j<=jmax;j++)
                    a[i][j]=0;              //превращаем прямоугольник в нули
            setRectangleCount(a);           //вызываем метод заново, чтобы проверить, остались ли прямоугольники
        }
    }
}
