package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexandr on 15.03.16.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage((Order) arg + " was cooked by " + (Cook) observable);
    }
}
