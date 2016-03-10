package com.javarush.test.level12.lesson09.task02;

/* Интерфейсы Fly, Run, Swim
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        void moveXYZ(int x, int y, int z);
    }
    public interface Run
    {
        void moveXY(int x, int y);
    }
    public interface Swim
    {
        void dive(int x, int y, int z);
    }

}
