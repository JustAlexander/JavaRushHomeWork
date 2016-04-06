package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by alexandr on 01.04.16.
 */
public class StatisticAdvertisementManager
{
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public Map<String, Integer> getActiveVideoSet()
    {
        Map<String, Integer> activeVideoSet = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement ad : AdvertisementStorage.getInstance().list())
        {
            if (ad.getHits() > 0)
                activeVideoSet.put(ad.getName(), ad.getHits());
        }
        return activeVideoSet;
    }

    public Set<String> getArchivedVideoSet()
    {
        Set<String> archivedVideoSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement ad : AdvertisementStorage.getInstance().list())
        {
            if (ad.getHits() == 0)
                archivedVideoSet.add(ad.getName());
        }
        return archivedVideoSet;
    }
}
