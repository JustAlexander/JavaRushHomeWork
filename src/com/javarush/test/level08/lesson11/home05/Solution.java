package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String out = "";

        for (int i = 0; i < s.length(); i++)
        {
            if (s.substring(i, i+1).equals(" "))
                if (!s.substring(i+1, i+2).equals(" "))
                {
                    out += " ";
                    out += s.substring(i+1, i+2).toUpperCase();
                    i++;
                }
                else out += s.substring(i, i+1);
            else
            if (i==0)
                if (!s.substring(0, 1).equals(" "))
                    out += s.substring(0, 1).toUpperCase();
                else
                    out += s.substring(0, 1);
            else
                out += s.substring(i, i+1);

        }
        System.out.println(out);
    }


}
