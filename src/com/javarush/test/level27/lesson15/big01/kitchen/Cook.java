package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexandr on 15.03.16.
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg)
    {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        CookedOrderEventDataRow event = new CookedOrderEventDataRow(order.tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(event);
        setChanged();
        notifyObservers(order);
    }
}
