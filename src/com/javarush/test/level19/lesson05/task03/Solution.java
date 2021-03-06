package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(new File(reader.readLine()));
        FileWriter output = new FileWriter(reader.readLine());
        while (input.hasNext()) {
            if (input.hasNextInt())
                output.write(input.next() + " ");
            else input.next();
        }
        reader.close();
        input.close();
        output.close();
    }
}
