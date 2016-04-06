package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexandr on 15.03.16.
 */
public class Cook extends Observable
{
    private String name;
    private boolean busy;

    public boolean isBusy()
    {
        return busy;
    }

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void startCookingOrder(Order order)
    {
        busy = true;
        try
        {
            Thread.sleep(order.getTotalCookingTime()*10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        CookedOrderEventDataRow event = new CookedOrderEventDataRow(order.tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticEventManager.getInstance().register(event);
        setChanged();
        notifyObservers(order);
        busy = false;
    }
}
