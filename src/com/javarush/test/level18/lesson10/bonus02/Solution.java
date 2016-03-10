package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        if (args.length > 0)
            if (args[0].equals("-c"))
                add(args, fname);
        reader.close();
    }

    public static int getLastId(String fname) throws IOException
    {
        Scanner file = new Scanner(new File(fname));
        int maxId = Integer.MIN_VALUE;
        if (isEmpty(fname))
            maxId = 0;
        else
        {
            while (file.hasNextLine())
            {
                String line = file.nextLine();
                line = line.substring(0, 8).trim();
                if (line.equals(""))
                    maxId = 0;
                else
                {
                    int id = Integer.parseInt(line);
                    if (id > maxId)
                        maxId = id;
                }
            }
        }
        file.close();
        return maxId;
    }

    public static void add(String[] args, String fname) throws IOException {
        if (args.length < 4)
            return;
        FileWriter file = new FileWriter(fname, true);
        String id = String.format("%-8.8s", getLastId(fname) + 1);
        String productName = String.format("%-30.30s", getProductNameInArgs(args));
        String price = String.format("%-8.8s", String.format(Locale.US, "%.2f", Double.parseDouble(args[args.length-2])));
        String quantity = String.format("%-4.4s", args[args.length-1]);
        if (!isNewLine(fname) && !isEmpty(fname))
            file.write(System.getProperty( "line.separator" ));
        file.write(id + productName + price + quantity);
        file.close();
    }

    public static String getProductNameInArgs(String[] args) {
        StringBuilder productName = new StringBuilder();
        for (int i = 1; i < args.length - 2; i++) {
            productName.append(args[i]+" ");
        }
        return productName.toString();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static boolean isEmpty(String file) throws IOException //Пустой ли файл?
    {
        File file1 = new File(file);
        return !file1.exists() || file1.length() == 0;
    }

    private static boolean isNewLine(String fname) throws IOException
    {
        FileInputStream file = new FileInputStream(fname);
        int i=0;
        while (file.available() > 0)
            i = file.read();
        return i == 10;

    }
}
