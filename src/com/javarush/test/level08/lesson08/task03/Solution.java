package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Абрамов", "Игорь");
        map.put("Ларин", "Макс");
        map.put("Потапкин", "Рома");
        map.put("Ложкин", "Саша");
        map.put("Давыдов", "Рома");
        map.put("Хрущев", "Слава");
        map.put("Иванов", "Рома");
        map.put("Суворов", "Макс");
        map.put("Лапин", "Сергей");
        map.put("Рылов", "Игорь");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if (name.equals(entry.getValue()))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if (familiya.equals(entry.getKey()))
                count++;
        }
        return count;
    }
}
