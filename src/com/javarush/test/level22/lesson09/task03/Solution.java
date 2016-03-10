package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner inFile = new Scanner(new File(reader.readLine()));
        StringBuilder allLines = new StringBuilder();
        while (inFile.hasNext()) {
            allLines.append(inFile.nextLine()+ " ");
        }
        String[] words = allLines.toString().split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        for (String w : words){
            if (w == null || w.isEmpty())
                return new StringBuilder();
        }
        if (words[0].equals(""))
            return new StringBuilder(words[0]);
        if (words.length == 1)
            return new StringBuilder(words[0]);

        List<String> list = new ArrayList<>(Arrays.asList(words));

        StringBuilder result = new StringBuilder();
        boolean up = false;
        while (true) {
            for (int i = 0; i < list.size()-1; i++) {
                if (Character.toUpperCase(list.get(i).charAt(list.get(i).length()-1)) != Character.toUpperCase(list.get(i+1).charAt(0))) {
                    up = true;
                    break;
                }
            }
            if (up) {
                Collections.shuffle(list);
                up = false;
            }
            else break;
        }
        for (String s : list) {
            result.append(s + " ");
        }
        result = new StringBuilder(result.toString().trim());
        return result;
    }
}
