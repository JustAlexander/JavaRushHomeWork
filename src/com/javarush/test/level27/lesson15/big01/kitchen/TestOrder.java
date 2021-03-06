package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexandr on 04.04.16.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        int countOfDishes = (int)(Math.random() * Dish.values().length);
        for (int i = 0; i < countOfDishes; i++) {
            dishes.add(Dish.values()[(int)(Math.random() * Dish.values().length)]);
        }
    }
}
