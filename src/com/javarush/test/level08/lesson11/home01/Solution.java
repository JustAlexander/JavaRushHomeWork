package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        int i = 1;
        for (Cat pair : cats)
        {
            if (i == 3)
                cats.remove(pair);
            i++;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> set = new HashSet<Cat>();
        set.add(new Cat("Barsik"));
        set.add(new Cat("Sharik"));
        set.add(new Cat("Murzik"));
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat pair : cats)
            System.out.println(pair);
    }

    public static class Cat
    {
        public String name;

        public Cat(String name)
        {
            this.name = name;
        }


    }
}
