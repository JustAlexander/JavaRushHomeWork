package com.javarush.test.level15.lesson12.home04;

/**
 * Created by user on 22.11.14.
 */
public class Moon implements Planet
{
    private static Moon ourInstance;

    public static Moon getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Moon();
        return ourInstance;
    }

    private Moon()
    {
    }
}
