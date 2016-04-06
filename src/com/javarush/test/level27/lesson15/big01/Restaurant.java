package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by alexandr on 14.03.16.
 */
public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Vova");
        Cook cook2 = new Cook("Petr");
        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);
        List<Tablet> tabletList = new ArrayList<>();
        OrderManager orderManager = new OrderManager();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);
            tabletList.add(tablet);
        }
        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(generatorTask);
        thread.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
