package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> cats = new HashMap<String, Cat>();
        cats.put("Barsik", new Cat("Barsik"));
        cats.put("Basta", new Cat("Basta"));
        cats.put("Barival", new Cat("Barival"));
        cats.put("Busja", new Cat("Busja"));
        cats.put("Musja", new Cat("Musja"));
        cats.put("Anfisa", new Cat("Anfisa"));
        cats.put("Selesta", new Cat("Selesta"));
        cats.put("Murzik", new Cat("Murzik"));
        cats.put("Komok", new Cat("Komok"));
        cats.put("Lapka", new Cat("Lapka"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> set = new HashSet<Cat>();
        set.addAll(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
