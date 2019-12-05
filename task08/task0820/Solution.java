package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogresult = new HashSet<>();
        dogresult.add(new Dog());
        dogresult.add(new Dog());
        dogresult.add(new Dog());
        return dogresult;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
         Set<Object> pets = new HashSet<>();
         for(Object cat: cats)
             pets.add(cat);
         for(Object dog: dogs)
             pets.add(dog);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Set<Object> copypets = new HashSet<>(pets);
        Set<Object> copycats = new HashSet<>(cats);
        for(Object pet:copypets)
        {
            for(Object cat:copycats)
             if(pet.equals(cat)) pets.remove(cat);
        }

    }

    public static void printPets(Set<Object> pets) {
        for(Object pet: pets)
            System.out.println(pet);
    }
public static class Dog{
        public Dog() {

    }
}
public static class Cat{
        public Cat() {

    }
}
    //напишите тут ваш код
}
