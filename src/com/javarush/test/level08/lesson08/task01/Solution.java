package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> list = new HashSet<String>();

        list.add("Любовь");
        list.add("Лак");
        list.add("Лом");
        list.add("Лошадь");
        list.add("Ляшка");
        list.add("Ложка");
        list.add("Локоть");
        list.add("Ладога");
        list.add("Лада");
        list.add("Лебедь");
        list.add("Лиза");
        list.add("Лето");
        list.add("Лера");
        list.add("Леша");
        list.add("Лена");
        list.add("Литр");
        list.add("Лево");
        list.add("Ливень");
        list.add("Лото");
        list.add("Лондон");

        return list;
    }
}
