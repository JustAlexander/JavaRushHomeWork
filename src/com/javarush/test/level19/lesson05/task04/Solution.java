package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(new File(reader.readLine()));
        FileWriter output = new FileWriter(reader.readLine());
        while (input.hasNextLine()) {
            String line = input.nextLine();
            line = line.replace('.', '!');
            output.write(line);
            if (input.hasNextLine())
                output.write(System.getProperty("line.separator"));
        }
        reader.close();
        input.close();
        output.close();
    }
}
