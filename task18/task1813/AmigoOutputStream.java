package com.javarush.task.task18.task1813;

import java.io.*;


/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream outputStream;



    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream outputStream) throws IOException {
        super(fileName);
        this.outputStream=outputStream;
    }


    public static void main(String[] args) throws NullPointerException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }




    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream.flush();
        String data = "JavaRush © All rights reserved.";
        outputStream.write(data.getBytes());
        outputStream.close();
    }
}
