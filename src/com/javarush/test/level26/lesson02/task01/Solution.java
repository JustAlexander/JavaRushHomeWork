package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        final double median;
        Arrays.sort(array);
        if (array.length % 2 == 0)
            median = (array[array.length/2]+array[array.length/2-1])/2.0;
        else median = array[array.length/2];
        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer i1, Integer i2)
            {
                int res = (int) (Math.abs(i1-median) - Math.abs(i2-median));
                return res != 0 ? res : i1 - i2;
            }
        });
        return array;
    }
}
