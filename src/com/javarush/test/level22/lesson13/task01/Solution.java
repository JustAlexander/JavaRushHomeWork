package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer s = new StringTokenizer(query, delimiter);
        String[] result = new String[s.countTokens()];
        int i = 0;
        while (s.hasMoreTokens()) {
            result[i] = s.nextToken();
            i++;
        }
        return result;
    }
}
