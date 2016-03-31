package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alexandr on 28.03.16.
 */
public class StatisticManager
{
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager ourInstance = new StatisticManager();
    private Set<Cook> cookSet = new HashSet<>();

    public static StatisticManager getInstance()
    {
        return ourInstance;
    }

    private StatisticManager()
    {

    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    public void register(Cook cook)
    {
        cookSet.add(cook);
    }

    public Map<Date, Float> getAdvertisementProfit()
    {
        Map<Date, Float> profitMap = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> dataList = new ArrayList<>(statisticStorage.getData(EventType.SELECTED_VIDEOS));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;
        for (EventDataRow dataRow : dataList)
        {
            VideoSelectedEventDataRow selectedEventDataRow = (VideoSelectedEventDataRow) dataRow;
            date = new Date(sdf.format(selectedEventDataRow.getDate()));
            profitMap.put(date, profitMap.containsKey(date) ? profitMap.get(date) + selectedEventDataRow.getAmount() / 100f : selectedEventDataRow.getAmount() / 100f);
        }
        return profitMap;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading()
    {
        Map<Date, Map<String, Integer>> loadingMap = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> dataList = new ArrayList<>(statisticStorage.getData(EventType.COOKED_ORDER));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;
        for (EventDataRow dataRow : dataList)
        {
            CookedOrderEventDataRow cookedEvent = (CookedOrderEventDataRow) dataRow;
            date = new Date(sdf.format(cookedEvent.getDate()));
            if (loadingMap.containsKey(date))
            {
                loadingMap.get(date).put(cookedEvent.getCookName(), loadingMap.get(date).containsKey(cookedEvent.getCookName()) ?
                        loadingMap.get(date).get(cookedEvent.getCookName()) + cookedEvent.getTime() : cookedEvent.getTime());
            }
            else
            {
                loadingMap.put(date, new TreeMap<String, Integer>());
                loadingMap.get(date).put(cookedEvent.getCookName(), cookedEvent.getTime());
            }
        }
        return loadingMap;
    }

    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> storageMap;

        StatisticStorage()
        {
            storageMap = new HashMap<>();
            for (EventType eventType : EventType.values())
            {
                storageMap.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data)
        {
            storageMap.get(data.getType()).add(data);
        }

        private List<EventDataRow> getData(EventType type)
        {
            return storageMap.get(type);
        }
    }
}
