package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        int height = image.length;
        int width = image[0].length;

        if (x < 0 || y < 0 || x >= width || y >= height || image[y][x].equals(desiredColor)) {
            return false;
        }

        Color oldColor = image[y][x];

        image[y][x] = desiredColor;

        if ( y > 0 && image[y - 1][x] == oldColor) {
            paintFill(image, x, y - 1, desiredColor);
        }

        if ( (y < image.length - 1) && image[y + 1][x] == oldColor) {
            paintFill(image, x, y + 1, desiredColor);
        }

        if ( x > 0 && image[y][x - 1] == oldColor) {
            paintFill(image, x - 1, y, desiredColor);
        }

        if ( (x < image[0].length - 1) && image[y][x + 1] == oldColor) {
            paintFill(image, x + 1, y, desiredColor);
        }

        return true;
    }


   /* private static boolean firstCall = true;
    private static Boolean[][] fillingPartOfImage;

    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        boolean result = recursiveMethod(image,x,y,desiredColor);
        if(!result)
            return false;
        else{
            for(int i=0;i<image.length;i++)
                for(int j=0;j<image[0].length;j++)
                    if(fillingPartOfImage[i][j]) image[i][j] = desiredColor;
            return true;
        }
    }

    private boolean recursiveMethod(Color[][] image, int x, int y, Color desiredColor){
        try {
            if(image[y][x]==desiredColor)
                return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        if(firstCall) {

            int height = image.length;
            int width = image[0].length;

            fillingPartOfImage = new Boolean[height][width]; //массив для определения необходимых для заливки клеток

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++)
                    fillingPartOfImage[i][j] = false;
            }

            fillingPartOfImage[y][x] = true;
        }

        firstCall = false;
        Color colorOfPressedPart = image[y][x];

        //Проверяем, принадлежит ли точка ... закрашиваемой области:

        if(x>0 && (image[y][x-1]==colorOfPressedPart) && !fillingPartOfImage[y][x-1]){ //слева
            fillingPartOfImage[y][x-1] = true;
            recursiveMethod(image, x-1, y, desiredColor);
        }

        if(y>0 && (image[y-1][x]==colorOfPressedPart) && !fillingPartOfImage[y-1][x]){ //сверху
            fillingPartOfImage[y-1][x] = true;
            recursiveMethod(image, x, y-1, desiredColor);
        }

        if(x<image[0].length-1 && (image[y][x+1]==colorOfPressedPart) && !fillingPartOfImage[y][x+1]){ //справа
            fillingPartOfImage[y][x+1] = true;
            recursiveMethod(image, x+1, y, desiredColor);
        }

        if(y<image.length-1 && (image[y+1][x]==colorOfPressedPart) && !fillingPartOfImage[y+1][x]){ //снизу
            fillingPartOfImage[y+1][x] = true;
            recursiveMethod(image, x, y+1, desiredColor);
        }

        return true;
    }*/
}
