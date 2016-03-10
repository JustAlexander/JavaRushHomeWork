package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by user on 23.11.14.
 */
public class Plane implements Flyable
{
    int countPas;
    @Override
    public void fly()
    {

    }

    public Plane(int countPas)
    {
        this.countPas = countPas;
    }
}
