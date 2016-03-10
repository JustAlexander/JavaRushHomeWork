package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile file1 = new RandomAccessFile(reader.readLine(), "rw");
        RandomAccessFile file2 = new RandomAccessFile(reader.readLine(), "r");
        byte[] b1 = new byte[(int) file2.length()];
        byte[] b2 = new byte[(int) file1.length()];
        file2.read(b1);
        file1.read(b2);
        file1.seek(0);
        file1.write(b1);
        file1.write(b2);
        reader.close();
        file1.close();
        file2.close();
    }
}
