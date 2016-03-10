package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //File file = new File(reader.readLine());
        Scanner inFile = new Scanner(new File(reader.readLine()));
        StringBuilder allLines = new StringBuilder();
        while (inFile.hasNext()) {
            allLines.append(inFile.nextLine()+ " ");
        }
        System.out.println(allLines.toString());
        String[] words = allLines.toString().split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            word.reverse();
            String w = words[i];
            for (int j = i+1; j < words.length; j++) {
                String s = words[j];
                if (word.toString().equals(s)) {
                    Pair p = new Pair();
                    p.first = w;
                    p.second = s;
                    result.add(p);
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
