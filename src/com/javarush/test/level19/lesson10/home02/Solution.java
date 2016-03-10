package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length < 1)
            return;
        Scanner file = new Scanner(new File(args[0]));
        Map<String, Double> people = new TreeMap<>();
        while (file.hasNext()) {
            String[] line = file.nextLine().split(" ");
            if (people.containsKey(line[0]))
                people.put(line[0], people.get(line[0]) + Double.parseDouble(line[1]));
            else
                people.put(line[0], Double.parseDouble(line[1]));
        }
        file.close();
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : people.entrySet())
            if (max < entry.getValue())
                max = entry.getValue();
        for (Map.Entry<String, Double> entry : people.entrySet())
            if (max == entry.getValue())
                System.out.println(entry.getKey());
    }
}