package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alexandr on 14.03.16.
 */
public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook cook = new Cook("Amigos");
        cook.setQueue(QUEUE);
        Cook cook2 = new Cook("Dominik");
        cook2.setQueue(QUEUE);

        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        cook2.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(QUEUE);
            tablets.add(tablet);
        }

        Thread cookThread = new Thread(cook);
        cookThread.start();
        Thread cook2Thread = new Thread(cook2);
        cook2Thread.start();

        Thread orderGenerator = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        orderGenerator.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){}
        orderGenerator.interrupt();

        while (cook.isBusy() || cook2.isBusy()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
        }

        cookThread.interrupt();
        cook2Thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
