package com.javarush.test.level26.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private ArrayList<Comparator<T>> comparables;

        public CustomizedComparator(Comparator<T>... comps)
        {
            this.comparables = new ArrayList<>(comps.length);
            Collections.addAll(comparables, comps);
        }

        @Override
        public int compare(T t, T t1)
        {
            int i;
            for (Comparator<T> comparable : comparables)
            {
                i = comparable.compare(t, t1);
                if (i != 0) return i;
            }
            return 0;
        }
    }
}
