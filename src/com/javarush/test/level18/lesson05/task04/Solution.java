package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        while (file1.available() > 0)
            list.add(file1.read());
        for (int i = list.size()-1; i >= 0; i--) {
            file2.write(list.get(i));
        }
        reader.close();
        file1.close();
        file2.close();
    }
}
