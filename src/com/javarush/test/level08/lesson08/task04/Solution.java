package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JANUARY 12 1940"));
        map.put("Дикаприо", new Date("FEBRUARY 14 1930"));
        map.put("Ддлофыва", new Date("MARCH 1 1950"));
        map.put("АОфывааы", new Date("APRIL 23 1680"));
        map.put("Ралорыва", new Date("JUNE 21 1970"));
        map.put("ШГруываы", new Date("JULY 23 1960"));
        map.put("РГУылгуа", new Date("AUGUST 4 1580"));
        map.put("Ишгаываа", new Date("SEPTEMBER 14 1940"));
        map.put("РГшрпыаы", new Date("OCTOBER 15 1980"));
        map.put("Уаырвашг", new Date("DECEMBER 18 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> current = iterator.next();
            if (current.getValue().getMonth() > 4 && current.getValue().getMonth() < 8)
                iterator.remove();
        }

    }
}
