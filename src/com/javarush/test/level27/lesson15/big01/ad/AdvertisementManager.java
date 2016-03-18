package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alexandr on 16.03.16.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        List<Advertisement> ad = new ArrayList<>();

        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getDuration() <= timeSeconds * 60)
                ad.add(advertisement);
        }

        if (ad.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(ad, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) ((o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying()) ?
                                        o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() :
                                        o1.getAmountPerOneDisplaying() * 1000.0 / o1.getDuration() -
                                                o2.getAmountPerOneDisplaying() * 1000.0 / o2.getDuration());
            }
        });

        for (Advertisement a : ad) {
            ConsoleHelper.writeMessage(a.getName() + " is displaying... " + a.getAmountPerOneDisplaying() + ", " +
                    a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
            a.revalidate();
        }
    }
}