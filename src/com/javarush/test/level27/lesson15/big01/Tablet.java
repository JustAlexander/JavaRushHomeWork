package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alexandr on 14.03.16.
 */
public class Tablet extends Observable
{
    private final int number;
    private AdvertisementManager manager;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (order.isEmpty()) return;
            manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            setChanged();
            notifyObservers(order);
            try
            {
                manager.processVideos();
            }
            catch (NoVideoAvailableException e)
            {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    @Override
    public String toString()
    {
        return "Tablet{" + "number=" + number + '}';
    }
}
