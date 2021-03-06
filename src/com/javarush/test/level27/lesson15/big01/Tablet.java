package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alexandr on 14.03.16.
 */
public class Tablet
{
    private final int number;
    private AdvertisementManager manager;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            prepareOrder(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    public void createTestOrder()
    {
        try
        {
            TestOrder order = new TestOrder(this);
            prepareOrder(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return;
        }
    }

    private void prepareOrder(Order order)
    {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty()) return;
        manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        queue.add(order);
        try
        {
            manager.processVideos();
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString()
    {
        return "Tablet{" + "number=" + number + '}';
    }
}
