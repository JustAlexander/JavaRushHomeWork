package com.javarush.test.level21.lesson05.task01;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution s = (Solution) o;

        boolean f = false;
        boolean l = false;

        if (s.first == null && first == null) f = true;
        if (s.last == null && last == null) l = true;

        if (s.first != null && first != null) f = s.first.equals(first);
        if (s.last != null && last != null) l = s.last.equals(last);

        return f && l;
    }

    @Override
    public int hashCode() {

        return 31*(first==null?0:first.hashCode()) + (last==null?0:last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution("Emando", "Duck"));
        s.add(new Solution(null, null));
        Solution w = new Solution("Donald", "Duck");
        for (Solution q : s)
            System.out.println(q.equals(w));
        System.out.println(s.contains(new Solution(null, null)));
    }
}
