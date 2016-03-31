package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by alexandr on 28.03.16.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;
    private EventType type;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
        type = EventType.SELECTED_VIDEOS;
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

    public long getAmount()
    {
        return amount;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
