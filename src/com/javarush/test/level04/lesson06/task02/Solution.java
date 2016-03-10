package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());

        System.out.println(max4(a1, a2, a3, a4));
    }

    public static int max4(int a1, int a2, int a3, int a4)
    {
        int q1 = max2(a1, a2);
        int q2 = max2(a3, a4);
        if (q1 > q2) return q1;
        else return q2;
    }

    public static int max2(int a1, int a2)
    {
        if (a1 > a2) return a1;
        else return a2;
    }
}
