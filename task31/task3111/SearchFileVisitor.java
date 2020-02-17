package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles=new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if(this.isCorrespondingFile(file,content))
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    private boolean isCorrespondingFile(Path file,byte[] content) {
            return isValidPartOfName(file)&&
                    isValidPartOfContent(content)&&
                    isValidMinSize(content)&&
                    isValidMaxSize(content);
    }

    private boolean isValidPartOfName(Path file){
        return this.partOfName==null||file.getFileName().toString().contains(this.partOfName);
    }
    private boolean isValidPartOfContent(byte[] content){
        String fileContent= new String(content);
        return this.partOfContent==null||fileContent.contains(this.partOfContent);
    }

    private boolean isValidMinSize(byte[] content){
         return this.minSize==0||content.length>this.minSize;
    }

    private boolean isValidMaxSize(byte[] content){
        return this.maxSize==0||content.length<this.maxSize;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }


    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

}
