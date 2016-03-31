package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by alexandr on 28.03.16.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow
{
    private int totalDuration;
    private Date currentDate;
    private EventType type;

    public NoAvailableVideoEventDataRow(int totalDuration)
    {
        this.totalDuration = totalDuration;
        currentDate = new Date();
        type = EventType.NO_AVAILABLE_VIDEO;
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
        return totalDuration;
    }
}
