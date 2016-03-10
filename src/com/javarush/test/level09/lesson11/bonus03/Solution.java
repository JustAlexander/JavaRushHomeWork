package com.javarush.test.level09.lesson11.bonus03;

import sun.management.resources.agent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        Map<Integer, Integer> chisla = new HashMap<Integer, Integer>();
        Map<Integer, String> slova = new HashMap<Integer, String>();
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
                chisla.put(i, Integer.parseInt(array[i]));
            else
                slova.put(i, array[i]);
        }
        List<Integer> listChisla = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++)
        {
            if (chisla.containsKey(i))
                listChisla.add(chisla.get(i));
        }
        List<String> listSlova = new ArrayList<String>();
        for (int i = 0; i < array.length; i++)
        {
            if (slova.containsKey(i))
                listSlova.add(slova.get(i));
        }
        for (int i = 0; i < listChisla.size() - 1; i++)
            for (int j = 0; j < listChisla.size() - i - 1; j++)
                if (listChisla.get(j) < listChisla.get(j + 1))
                {
                    int buf = listChisla.get(j);
                    listChisla.set(j, listChisla.get(j+1));
                    listChisla.set(j+1, buf);
                }
        for (int i = 0; i < listSlova.size() - 1; i++)
            for (int j = 0; j < listSlova.size() - i - 1; j++)
                if (isGreaterThen(listSlova.get(j), listSlova.get(j + 1)))
                {
                    String buf = listSlova.get(j);
                    listSlova.set(j, listSlova.get(j+1));
                    listSlova.set(j+1, buf);
                }
        int j = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (chisla.containsKey(i))
            {
                chisla.put(i, listChisla.get(j));
                j++;
            }
        }
        j = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (slova.containsKey(i))
            {
                slova.put(i, listSlova.get(j));
                j++;
            }
        }
        j = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (chisla.containsKey(i))
            {
                chisla.put(i, listChisla.get(j));
                j++;
            }
        }
        for (int i = 0; i < array.length; i++)
        {
            if (slova.containsKey(i))
                array[i] = slova.get(i);
            if (chisla.containsKey(i))
                array[i] = chisla.get(i).toString();
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
