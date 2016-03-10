package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        if (string.isEmpty())
            throw new TooShortStringException();
        int begin = string.indexOf('\t');
        int end = 0;
        for (int i = ++begin; i < string.length(); i++) {
            if (string.charAt(i) == '\t') {
                end = i--;
                break;
            }
        }
        if (end == 0) throw new TooShortStringException();
        return string.substring(begin, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }
}
