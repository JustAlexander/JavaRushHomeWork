package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by alexandr on 28.03.16.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        float totalAmount = 0.0f;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Locale.setDefault(Locale.ENGLISH);
        for (Map.Entry<Date, Float> entry : StatisticEventManager.getInstance().getAdvertisementProfit().entrySet())
        {
            totalAmount += entry.getValue();
            ConsoleHelper.writeMessage(sdf.format(entry.getKey()) + " - " + new DecimalFormat("#0.00").format(Math.round(entry.getValue()*100.0)/100.0));
        }
        ConsoleHelper.writeMessage("Total - " + new DecimalFormat("#0.00").format(Math.round(totalAmount*100.0)/100.0));
    }

    public void printCookWorkloading()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Locale.setDefault(Locale.ENGLISH);
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticEventManager.getInstance().getCookWorkloading().entrySet())
        {
            ConsoleHelper.writeMessage(sdf.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksLoading : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(cooksLoading.getKey() + " - " + (cooksLoading.getValue() + 59) / 60 + " min");
            }
        }
    }

    public void printActiveVideoSet()
    {
        for (Map.Entry<String, Integer> video : StatisticAdvertisementManager.getInstance().getActiveVideoSet().entrySet())
        {
            ConsoleHelper.writeMessage(video.getKey() + " - " + video.getValue());
        }
    }

    public void printArchivedVideoSet()
    {
        for (String s : StatisticAdvertisementManager.getInstance().getArchivedVideoSet())
        {
            ConsoleHelper.writeMessage(s);
        }
    }
}
