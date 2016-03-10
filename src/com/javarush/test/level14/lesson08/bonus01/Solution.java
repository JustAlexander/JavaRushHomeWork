package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//2
        try
        {
            MessageDigest digest = MessageDigest.getInstance("S1");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//3
        try
        {
            int[] array = new int[10];
            array[11] = 0;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//4
        try
        {
            String str = "asdfg";
            str.charAt(6);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//5
        try
        {
            int[] array = new int[-4];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//6
        try
        {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//7
        try
        {
            Object ch = new Character('*');
            System.out.println((Byte)ch);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//8
        try
        {
            int[] nNulArray = new int[5];
            nNulArray = null;
            int i = nNulArray.length;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//9
        try
        {
            throw new IllegalAccessException("demo");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//10
        try
        {
            List<String> list = new ArrayList<String>();
            list.add("asd");
            list.add("a2sd");
            list.add("as3d");
            Iterator<String> iterator = list.iterator();
            list.remove(0);
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
