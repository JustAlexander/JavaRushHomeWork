package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть
строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner file1 = new Scanner(new File(reader.readLine()));
        Scanner file2 = new Scanner(new File(reader.readLine()));
        List<String> f1 = new ArrayList<>();
        List<String> f2 = new ArrayList<>();
        while (file1.hasNext())
            f1.add(file1.nextLine());
        while (file2.hasNext())
            f2.add(file2.nextLine());

        while (true) {
            if (f1.get(0).equals(f2.get(0))) {
                lines.add(new LineItem(Type.SAME, f1.get(0)));
                f1.remove(0);
                f2.remove(0);
            }
            else if (f1.get(0).equals(f2.get(1))) {
                lines.add(new LineItem(Type.ADDED, f2.get(0)));
                lines.add(new LineItem(Type.SAME, f1.get(0)));
                f1.remove(0);
                f2.remove(0);
                f2.remove(0);
            }
            else if (f1.get(1).equals(f2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, f1.get(0)));
                lines.add(new LineItem(Type.SAME, f1.get(1)));
                f1.remove(0);
                f1.remove(0);
                f2.remove(0);
            }
            else {
                lines.add(new LineItem(Type.REMOVED, f1.get(0)));
                lines.add(new LineItem(Type.ADDED, f2.get(0)));
                f1.remove(0);
                f2.remove(0);
            }
            if (f1.size() == 0) {
                for (String s : f2)
                    lines.add(new LineItem(Type.ADDED, s));
                break;
            }
            if (f2.size() == 0){
                for (String s : f1)
                    lines.add(new LineItem(Type.REMOVED, s));
                break;
            }
        }

        reader.close();
        file1.close();
        file2.close();
        for (LineItem t : lines)
            System.out.println(t.type + " " + t.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}