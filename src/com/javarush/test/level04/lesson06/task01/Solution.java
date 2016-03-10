package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a;
        int b;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());

            System.out.println(min(a, b));

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }

    public static int min(int a, int b)
    {
        if (a < b) return a;
        else return b;
    }
}