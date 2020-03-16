package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        try {
            String decodingPath = URLDecoder.decode(packageName,"UTF-8");
            File[] files = new File(decodingPath).listFiles();

            for(File currentFile:files){
                if(currentFile.toString().endsWith(".class")){
                    Class clazz = new MyClassLoader().loadClass(currentFile.toPath());
                    hiddenClasses.add(clazz);
                }
            }


        } catch (UnsupportedEncodingException ignore) {

        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        Class hiddenClass = null;
        for(Class clazz: hiddenClasses){
            if(clazz.getSimpleName().startsWith(key)) {
                hiddenClass = clazz;
                break;
            }
        }

        HiddenClass neededHiddenClass = null;

        if(HiddenClass.class.isAssignableFrom(hiddenClass)){
            try {
                Constructor constructor = hiddenClass.getDeclaredConstructor();
                constructor.setAccessible(true);

                neededHiddenClass = (HiddenClass) constructor.newInstance();

            } catch (Exception ignore){

            }
        }


        return neededHiddenClass;
    }

    private class MyClassLoader extends ClassLoader{
        Class<?> loadClass(Path path){
             try {
                byte[] buffer = Files.readAllBytes(path);
                return defineClass(null,buffer,0,buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
             return null;
        }
    }
}

