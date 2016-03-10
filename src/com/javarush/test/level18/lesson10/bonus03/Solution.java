package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        if (args.length > 0)
        {
            if (args[0].equals("-d"))
                delete(args, fname);
            if (args[0].equals("-u"))
                update(args, fname);
        }
        reader.close();
    }

    public static void delete(String[] args, String fname) throws IOException
    {
        Scanner file = new Scanner(new File(fname));
        List<String> list = new ArrayList<>();
        String Id = args[1];
        if (isEmpty(fname))
            System.out.println("Файл пустой");
        else
        {
            while (file.hasNextLine())
            {
                String line = file.nextLine();
                String lineId = line.substring(0, 8).trim();
                if (!lineId.equals(Id))
                    list.add(line);
            }
        }
        file.close();
        FileWriter writer = new FileWriter(fname);
        for (int i = 0; i < list.size(); i++)
        {
            if (i != list.size() - 1)
                writer.write(list.get(i) + System.getProperty("line.separator"));
            else
                writer.write(list.get(i));
        }
        writer.close();
    }

    public static void update(String[] args, String fname) throws IOException
    {
        Scanner file = new Scanner(new File(fname));
        List<String> list = new ArrayList<>();
        String Id = args[1];
        if (isEmpty(fname))
            System.out.println("Файл пустой");
        else
        {
            while (file.hasNextLine())
            {
                String line = file.nextLine();
                String lineId = line.substring(0, 8).trim();
                if (!lineId.equals(Id))
                    list.add(line);
                else {
                    String productName = String.format("%-30.30s", getProductNameInArgs(args));
                    String price = String.format("%-8.8s", String.format(Locale.US, "%.2f", Double.parseDouble(args[args.length-2])));
                    String quantity = String.format("%-4.4s", args[args.length-1]);
                    list.add(String.format("%-8.8s", lineId) + productName + price + quantity);
                }

            }
        }
        file.close();
        FileWriter writer = new FileWriter(fname);
        for (int i = 0; i < list.size(); i++)
        {
            if (i != list.size() - 1)
                writer.write(list.get(i) + System.getProperty("line.separator"));
            else
                writer.write(list.get(i));
        }
        writer.close();
    }

    public static String getProductNameInArgs(String[] args) {
        StringBuilder productName = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
            productName.append(args[i]+" ");
        }
        return productName.toString();
    }

    private static boolean isEmpty(String file) throws IOException //Пустой ли файл?
    {
        File file1 = new File(file);
        return !file1.exists() || file1.length() == 0;
    }
}