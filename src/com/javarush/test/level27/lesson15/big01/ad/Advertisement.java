package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by alexandr on 16.03.16.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
            amountPerOneDisplaying = Math.round((double)initialAmount / hits);

    }

    public void revalidate()
    {
        if (hits < 1) throw new UnsupportedOperationException();
        hits--;
        initialAmount -= amountPerOneDisplaying;
        amountPerOneDisplaying = Math.round((double)initialAmount / hits);
    }

    public int getHits()
    {
        return hits;
    }
}
