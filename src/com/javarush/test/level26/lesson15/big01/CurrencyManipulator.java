package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kd130487pas on 11.02.16.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {

        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.keySet().contains(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
            denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }

    public boolean hasMoney() {
        if (denominations.isEmpty())
            return false;
        else {
            for (Integer integer : denominations.values()) {
                if (integer != 0)
                    return true;
            }
            return false;
        }
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.putAll(denominations);
        Map<Integer, Integer> amountMap = new HashMap<>();
        int amount = 0;
        try {
            for (Map.Entry<Integer, Integer> entry : map.descendingMap().entrySet()) {
                amount = expectedAmount / entry.getKey();
                if (amount > 0) {
                    if (amount > entry.getValue())
                        amount = entry.getValue();
                    amountMap.put(entry.getKey(), amount);
                    expectedAmount -= amount * entry.getKey();
                    if (expectedAmount == 0) break;
                }
            }
        }
        catch (ConcurrentModificationException e) {}
        if (expectedAmount != 0)
            throw new NotEnoughMoneyException();
        for (Map.Entry<Integer, Integer> entry : amountMap.entrySet()) {
            denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
        }
        return amountMap;
    }
}
