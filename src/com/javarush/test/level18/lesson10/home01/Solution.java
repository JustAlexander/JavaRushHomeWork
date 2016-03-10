package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            List<Integer> list = new ArrayList<>();
            int col = 0;
            while(inputStream.available() > 0){
                int data = inputStream.read();
                if((data >= Integer.valueOf('A') && data <= Integer.valueOf('Z'))
                        || (data >= Integer.valueOf('a') && data <= Integer.valueOf('z'))){
                    col++;
                }
            }
            System.out.println(Integer.valueOf(col));
            inputStream.close();
        }
    }
}
