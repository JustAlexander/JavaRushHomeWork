package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Created by kd130487pas on 12.02.16.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int amount;
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            String s = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(s);
                if (amount <= 0) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    continue;
                }
                if (amount > 0 && manipulator.isAmountAvailable(amount)) {
                    TreeMap<Integer, Integer> map = new TreeMap<>();
                    map.putAll(manipulator.withdrawAmount(amount));
                    for (Map.Entry<Integer, Integer> entry : map.descendingMap().entrySet()) {
                        ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                    return;
                }
                else ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
            }
            catch (NotEnoughMoneyException m) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}
