package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandr on 01.04.16.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tablets = new ArrayList<>();
    private final int interval;
    @Override
    public void run()
    {
        if (tablets.isEmpty()) return;

        while (true)
        {
            try
            {
                Tablet tablet = tablets.get((int)(Math.random()*tablets.size()));
                tablet.createTestOrder();
                Thread.sleep(interval);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }
}
