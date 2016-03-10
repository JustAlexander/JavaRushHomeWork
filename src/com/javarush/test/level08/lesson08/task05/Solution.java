package com.javarush.test.level08.lesson08.task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
    public static HashMap<String, String> createMap() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("1", "Игорь");
        map.put("2", "Саша");
        map.put("3", "Даша");
        map.put("4", "Маша");
        map.put("5", "Игорь");
        map.put("6", "Ваня");
        map.put("7", "Саша");
        map.put("8", "Рома");
        map.put("9", "Игорь");
        map.put("10", "Дима");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        ArrayList<String> listValues = new ArrayList<String>(map.values());

        for (int i = 0; i < listValues.size(); i++)
            for (int n = i+1; n < listValues.size(); n++)
                if (listValues.get(i).equals(listValues.get(n)))
                {
                    removeItemFromMapByValue(map, listValues.get(n));
                    break;
                }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
