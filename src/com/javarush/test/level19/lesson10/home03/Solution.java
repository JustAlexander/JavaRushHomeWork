package com.javarush.test.level19.lesson10.home03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length < 1)
            return;
        Scanner file = new Scanner(new File(args[0]));
        while (file.hasNext()) {
            String[] line = file.nextLine().split(" ");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, Integer.parseInt(line[line.length-3]));
            calendar.set(Calendar.MONTH, Integer.parseInt(line[line.length-2]) - 1);
            calendar.set(Calendar.YEAR, Integer.parseInt(line[line.length-1]));
            Date date = calendar.getTime();
            String name = "";
            for (int i = 0; i < line.length - 3; i++) {
                name = name + line[i] + " ";
            }
            name = name.substring(0, name.length()-1);
            PEOPLE.add(new Person(name, date));
        }
        file.close();
    }

}
