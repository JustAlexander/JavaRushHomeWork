package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kd130487pas on 11.02.16.
 */
public final class CurrencyManipulatorFactory {

    static Map<String, CurrencyManipulator> currencyManipulatorMap = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulatorMap.containsKey(currencyCode))
            return currencyManipulatorMap.get(currencyCode);
        else {
            CurrencyManipulator current = new CurrencyManipulator(currencyCode);
            currencyManipulatorMap.put(currencyCode, current);
            return current;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return currencyManipulatorMap.values();
    }
}
