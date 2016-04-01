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
        Cook cook = new Cook("Cmigo");
        Waitor waitor = new Waitor();
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        cook.addObserver(waitor);
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
