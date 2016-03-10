package com.javarush.test.level08.lesson11.home09;


import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date)
    {
        String[] dateSplit = date.split(" ");
        int startMonth = 0;
        String months[] = {
                "JANUARY", "FEBRUARY", "MARCH", "APRIL",
                "MAY", "JUNE", "JULY", "AUGUST",
                "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        for (int i = 0; i < 12; i++)
            if (months[i].equals(dateSplit[0]))
                startMonth = i;

        Date startDate = new Date(Integer.parseInt(dateSplit[2]), 0, 1);
        Date endDate = new Date(Integer.parseInt(dateSplit[2]), startMonth, Integer.parseInt(dateSplit[1]));

        long msTimeDistance = endDate.getTime() - startDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int)(msTimeDistance/msDay);

        return dayCount % 2 == 0;
    }
}
