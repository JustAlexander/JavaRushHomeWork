package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> sort = new ArrayList<Integer>();

        while (true)
        {
            try
            {
                String s = file.readLine();
                if (s.isEmpty()) break;
                list.add(Integer.parseInt(s));
            }
            catch (NullPointerException e)
            {
                break;
            }
        }
        for (int i : list)
            if (i % 2 == 0)
                sort.add(i);
        for (int i = 0; i < sort.size(); i++)
            for (int j = 0; j < sort.size() - i - 1; j++)
                if (sort.get(j) > sort.get(j+1))
                {
                    int buf = sort.get(j);
                    sort.set(j, sort.get(j+1));
                    sort.set(j+1, buf);
                }
        for (int i : sort)
            System.out.println(i);
    }
}
