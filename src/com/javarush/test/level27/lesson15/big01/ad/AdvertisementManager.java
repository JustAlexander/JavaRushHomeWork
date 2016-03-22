package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

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

        ad = knapSack(timeSeconds, ad, ad.size());

        if (ad == null || ad.isEmpty())
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

    private List<Advertisement> knapSack(int W, List<Advertisement> ad, int n) {
        if (n == 0 || W == 0)
            return null;
        if (ad.get(n-1).getDuration()/60 > W || ad.get(n-1).getHits() <= 0)
            return knapSack(W, ad, n-1);
        else {
            List<Advertisement> l1 = new ArrayList<>();
            l1.add(ad.get(n-1));
            List<Advertisement> t = knapSack(W - ad.get(n - 1).getDuration()/60, ad, n - 1);
            if (t != null) l1.addAll(t);
            List<Advertisement> l2 = knapSack(W, ad, n - 1);
            if (getTotalAmount(l1) == getTotalAmount(l2))
                if (getTotalTime(l1) == getTotalTime(l2)) {
                    return (l1.size() < (l2 != null ? l2.size() : Integer.MAX_VALUE)) ? l1 : l2;
                } else
                    return (getTotalTime(l1) > getTotalTime(l2)) ? l1 : l2;
            else return (getTotalAmount(l1) > getTotalAmount(l2)) ? l1 : l2;
        }
    }

    private long getTotalAmount(List<Advertisement> ad) {
        long totalAmount = 0;
        if (ad == null) return totalAmount;
        for (Advertisement a : ad) {
            totalAmount += a.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }

    private int getTotalTime(List<Advertisement> ad) {
        int totalTime = 0;
        if (ad == null) return totalTime;
        for (Advertisement a : ad) {
            totalTime += a.getDuration()/60;
        }
        return totalTime;
    }
}
