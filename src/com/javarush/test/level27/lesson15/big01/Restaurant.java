package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by alexandr on 14.03.16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Tablet tablet = new Tablet(5);
        Cook amigo = new Cook("Amigo");
        amigo.addObserver(new Waitor());
        tablet.addObserver(amigo);
        tablet.createOrder();
    }
}
