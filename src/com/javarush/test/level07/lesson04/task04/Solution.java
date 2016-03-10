package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] list = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
            list[i] = Integer.parseInt(reader.readLine());
        int n = list.length - 1;
        int b = 0;
        for (int i = 0; i < 5; i++)
        {
            b = list[n];
            list[n] = list[i];
            list[i] = b;
            n--;
        }
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}
