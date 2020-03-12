package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for(Class<?> clazz:classes)
            if(List.class.isAssignableFrom(clazz) && isPrivateStaticInnerClass(clazz) && isThrowingIndexOutOfBoundsException(clazz))
        return clazz;
            return null;
    }

    private static boolean isPrivateStaticInnerClass(Class<?> clazz){
        //  так тоже работало
        //        if (clazz.getModifiers() == (Modifier.PRIVATE + Modifier.STATIC))
        //            return true;
        int modifiersValue = clazz.getModifiers();
        return Modifier.isPrivate(modifiersValue) && Modifier.isStatic(modifiersValue);
    }

    private static boolean isThrowingIndexOutOfBoundsException(Class<?> clazz){
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            Method method = clazz.getDeclaredMethod("get", int.class);
            method.setAccessible(true);
            method.invoke(constructor.newInstance(),0);

        } catch (InvocationTargetException e) {
            if(e.getCause().toString().contains("IndexOutOfBoundsException"))
                return true;
        }
        catch (Exception ignore){

        }
        return false;
    }
}
