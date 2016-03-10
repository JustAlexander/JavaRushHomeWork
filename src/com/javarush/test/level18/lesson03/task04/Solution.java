package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        int glMin = Integer.MAX_VALUE;
        while (inputStream.available() > 0)
            list.add(inputStream.read());
        for (Integer bt : list) {
            int max = 0;
            for (Integer i : list)
                if (bt == i)
                    max++;
            if (max == glMin)
                if (!outList.contains(bt))
                {
                    outList.add(bt);
                }
            if (max < glMin) {
                outList.clear();
                outList.add(bt);
                glMin = max;
            }
        }
        for (Integer i : outList)
            System.out.print(i + " ");
        reader.close();
        inputStream.close();
    }

}
