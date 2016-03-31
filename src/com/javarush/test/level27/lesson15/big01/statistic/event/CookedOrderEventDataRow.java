package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by alexandr on 28.03.16.
 */
public class CookedOrderEventDataRow implements EventDataRow
{
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;
    private Date currentDate;
    private EventType type;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs)
    {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        currentDate = new Date();
        type = EventType.COOKED_ORDER;
    }

    @Override
    public EventType getType()
    {
        return type;
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return cookingTimeSeconds;
    }

    public String getCookName()
    {
        return cookName;
    }
}
