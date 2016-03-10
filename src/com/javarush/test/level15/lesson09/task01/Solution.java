package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(3.3, "asd");
        labels.put(4.3, "asd1");
        labels.put(5.3, "as2d");
        labels.put(6.3, "as3d");
        labels.put(7.3, "as4d");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
