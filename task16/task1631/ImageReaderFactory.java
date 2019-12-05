package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
   //Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
     public static ImageReader getImageReader(ImageTypes imageTypes) {
         if (imageTypes==null) throw new IllegalArgumentException("Неизвестный тип картинки");
         if (imageTypes.equals(imageTypes.JPG)) return new JpgReader();
         else if(imageTypes.equals(imageTypes.PNG)) return new PngReader();
         else return new BmpReader();

     }
}
