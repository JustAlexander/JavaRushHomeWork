package com.javarush.test.level21.lesson05.task03;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }
    //TODO: Забыл
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;
        boolean bstr = false;
        boolean bdat = false;
        boolean bsol = false;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;

        //if (!date.equals(solution1.date)) return false;
        if (date == null && solution1.date == null) bdat = true;
        if (date != null && solution1.date != null) bdat = solution1.date.equals(date);

        //if (!solution.equals(solution1.solution)) return false;
        if (solution == null && solution1.solution == null) bsol = true;
        if (solution != null && solution1.solution != null) bsol = solution1.solution.equals(solution);

        //if (!string.equals(solution1.string)) return false;
        if (string == null && solution1.string == null) bstr = true;
        if (string != null && solution1.string != null) bstr = solution1.string.equals(string);
        return bdat && bsol && bstr;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + (string==null?0:string.hashCode());
        temp = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date==null?0:date.hashCode());
        result = 31 * result + (solution==null?0:solution.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        //s.add(new Solution(123, "asd", 12.2, new Date(2015, 5, 12), null));
       // System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        Solution s1 = new Solution(123, "asd", 12.2, new Date(2015, 5, 12), null);
        Solution s2 = new Solution(123, "asd", 12.2, new Date(2015, 5, 12), s1);
        Solution s3 = new Solution(123, "asd", 12.2, new Date(2015, 5, 12), s1);
        Solution s4 = new Solution(123, null, 12.2, null, s2);
        System.out.println(s3.equals(s2));
        for (Solution solution : s) {

        }
    }
}
