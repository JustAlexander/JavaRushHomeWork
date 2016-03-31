package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

/**
 * Created by alexandr on 14.03.16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {

            Cook cook = new Cook("Cmigo");
            Waitor waitor = new Waitor();
            Tablet tablet = new Tablet(5);
            tablet.addObserver(cook);
            cook.addObserver(waitor);
            tablet.createOrder();

            Cook cook1 = new Cook("Amigo");
            Waitor waitor1 = new Waitor();
            Tablet tablet1 = new Tablet(5);
            tablet1.addObserver(cook1);
            cook1.addObserver(waitor1);
            tablet1.createOrder();

            Cook cook2 = new Cook("Bmigo");
            Waitor waitor2 = new Waitor();
            Tablet tablet2 = new Tablet(5);
            tablet2.addObserver(cook2);
            cook2.addObserver(waitor2);
            tablet2.createOrder();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
