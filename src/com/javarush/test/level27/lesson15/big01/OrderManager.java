package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alexandr on 05.04.16.
 */
public class OrderManager implements Observer
{
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    @Override
    public void update(Observable o, Object arg)
    {
        orderQueue.add((Order) arg);
    }

    public OrderManager()
    {
        Thread daemonThread = new Thread()
        {
            {
                setDaemon(true);
            }
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        if (!orderQueue.isEmpty())
                        {
                            for (Cook cook : StatisticEventManager.getInstance().getCookSet())
                            {
                                if (!cook.isBusy())
                                    cook.startCookingOrder(orderQueue.take());
                            }
                        }
                        sleep(10);
                    }
                    catch (InterruptedException e)
                    {

                    }
                }
            }
        };
        daemonThread.start();
    }
}
