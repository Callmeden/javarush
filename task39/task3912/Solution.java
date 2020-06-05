package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix1 = { {1,1,0,1,1,1},
                {1,0,1,0,1,1},
                {1,1,1,1,0,0},
                {0,1,1,1,1,0},
                {1,1,1,1,1,0} };  // maxSquare = 9

        int[][] matrix2 = { {0,1,1,1,1},
                {1,1,1,0,1,1},
                {1,1,0},
                {0,1,1,0,1,1},
                {1} };  // maxSquare = 4

        System.out.println("Must be 9: " + maxSquare(matrix1));
        System.out.println("Must be 4: " + maxSquare(matrix2));
    }

    public static int maxSquare(int[][] matrix) {
        int s = 0;
        int ySize = matrix.length;

        for(int i=0;i<ySize;i++) {
            int xSize = matrix[i].length;
            for (int j = 0; j < xSize; j++) {
                if (matrix[i][j] == 1) {
                    int distanceToTheBorders = Math.min(xSize - j, ySize - i);
                    for (int k = 0; k < distanceToTheBorders; k++)
                        if (doesSquareConsistOnlyOnes(matrix, i, j, i + k, j + k))
                            s = Math.max((k) * (k), s);
                        else break;
                }
            }
        }
        return s;
    }

    private static boolean doesSquareConsistOnlyOnes(int[][] matrix, int x1, int y1, int x2, int y2){
        try {
            for(int i = y1;i<y2;i++)
                for(int j=x1;j<x2;j++)
                    if(matrix[i][j]==0)
                        return false;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
