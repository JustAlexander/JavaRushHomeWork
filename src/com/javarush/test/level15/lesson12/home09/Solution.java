package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        url = url.substring(url.indexOf("?")+1, url.length());
        String[] params = url.split("&");
        String obj = "";
        String out = "";
        for (String pair : params)
        {
            int idx = -1;
            idx = pair.indexOf("=");
            if (idx==-1)
                out += pair + " ";
            else
            {
                out += pair.substring(0, idx) + " ";
                if (pair.substring(0, idx).equals("obj"))
                    obj = pair.substring(idx+1, pair.length());
            }
        }
        System.out.println(out.substring(0, out.length() - 1));
        if (!obj.isEmpty())
        {
            try
            {
                alert(Double.parseDouble(obj));
            }
            catch (Exception e)
            {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
