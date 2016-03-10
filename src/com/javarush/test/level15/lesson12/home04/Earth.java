package com.javarush.test.level15.lesson12.home04;

/**
 * Created by user on 22.11.14.
 */
public class Earth implements Planet
{
    private static Earth ourInstance;

    public static Earth getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Earth();
        return ourInstance;
    }

    private Earth()
    {
    }
}
