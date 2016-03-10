package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length < 2)
            return;
        Scanner inFile = new Scanner(new File(args[0]));
        FileWriter outFile = new FileWriter(new File(args[1]));
        String out = "";
        while (inFile.hasNext()) {
            String[] line = inFile.nextLine().split(" ");
            for (String s : line)
                if (s.length() > 6)
                    out = out + s + ",";
        }
        if (out.length() > 0)
            out = out.substring(0, out.length()-1);
        outFile.write(out);
        inFile.close();
        outFile.close();
    }
}
