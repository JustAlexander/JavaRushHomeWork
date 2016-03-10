package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (args.length < 1)
            return;
        String tag = args[0];
        String oTag = "<" + tag;
        String cTag = "</" + tag + ">";
        Scanner file = null;
        try
        {
            file = new Scanner(new File(reader.readLine()));
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String allInLine = "";
        while (file.hasNext())
            allInLine += file.nextLine();
        ArrayList<Pair> posOpenTag = new ArrayList();
        ArrayList<Pair> posCloseTag = new ArrayList();

        Pattern p = Pattern.compile(oTag + "|" + cTag);  // insert your pattern here
        Matcher m = p.matcher(allInLine);

        int countIn = 1;
        while (m.find()) {
            if (m.group().equals(oTag)) {
                posOpenTag.add(new Pair(countIn, m.start()));
                countIn++;
            }
            if (m.group().equals(cTag)) {
                countIn--;
                posCloseTag.add(new Pair(countIn, m.end()));
            }

        }
        for (Pair pairOpen : posOpenTag) {
            for (int i = 0; i < posCloseTag.size(); i++) {
                if (pairOpen.key == posCloseTag.get(i).key) {
                    System.out.println(allInLine.substring(pairOpen.index, posCloseTag.get(i).index));
                    posCloseTag.remove(i);
                    break;
                }
            }
        }
    }

    public static class Pair {
        public int key;
        public int index;

        public Pair(int key, int index)
        {
            this.key = key;
            this.index = index;
        }

        @Override
        public String toString()
        {
            return "Pair{" +
                    "key=" + key +
                    ", index=" + index +
                    '}';
        }
    }
}
