package com.javarush.test.level02.lesson08.task06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Вывод текста на экран
Написать функцию, которая выводит переданную строку (слово) на экран три раза, но в одной строке.
Слова должны быть разделены пробелом и не должны сливаться в одно.
*/
public class Solution
{
    public static void print3(String s)
    {
        System.out.print(s + " ");
        System.out.print(s + " ");
        System.out.println(s);

    }
    public static void main(String[] args)
    {
        print3("программист");
        print3("комп");
        print3(" сумка");

/* Вывод на экран должен быть следующим:
программист программист программист
комп комп комп
 сумка  сумка  сумка
*/
    }
}