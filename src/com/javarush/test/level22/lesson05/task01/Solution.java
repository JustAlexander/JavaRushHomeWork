package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        int begin = string.indexOf(" ");
        if (begin == -1) throw new TooShortStringException();
        int end = 0;
        int count = 0;
        for (int i = begin; i < string.length(); i++) {
            if (string.charAt(i) == ' ')
                count++;
            end = i;
            if (count == 4) break;
        }
        if (count < 4) throw new TooShortStringException();
        for (int i = ++end; i < string.length(); i++) {
            end = i;
            if (string.charAt(i) == ' ') {
                end--;
                break;
            }
        }
        return string.substring(++begin, ++end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("avaRush  - лучший сервис обучения Java"));
    }
}
