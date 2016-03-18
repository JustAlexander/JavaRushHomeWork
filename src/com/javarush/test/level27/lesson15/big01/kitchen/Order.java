package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by alexandr on 14.03.16.
 */
public class Order
{
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime += dish.getDuration();
        }
        return totalTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
