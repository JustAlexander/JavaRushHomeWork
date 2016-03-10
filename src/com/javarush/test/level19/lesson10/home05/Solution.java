package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length < 2)
            return;
        Scanner inputFile = new Scanner(new File(args[0]));
        FileWriter output = new FileWriter(args[1]);
        while (inputFile.hasNext())
        {
            String lines = inputFile.nextLine();
            String[] line = lines.split(" ");
            String out = "";
            for (String s : line)
                if (!s.matches("^\\d*$"))
                    if (!s.matches("^[^0-9]*$"))
                        out = out + s + " ";
            if ((out.length()!=0) && !inputFile.hasNext())
                out = out.substring(0, out.length()-1);
            output.write(out);
        }
        inputFile.close();
        output.close();
    }
}
