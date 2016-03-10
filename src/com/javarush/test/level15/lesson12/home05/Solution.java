package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(String s) {}
    public Solution(Integer i) {}
    public Solution(Number n) {}
    private Solution(int i) {}
    private Solution(double d) {}
    private Solution(short s) {}
    protected Solution(boolean b) {}
    protected Solution(char c) {}
    protected Solution(float f) {}
    Solution(byte b) {}
    Solution(long l) {}
    Solution(Object o) {}
}

