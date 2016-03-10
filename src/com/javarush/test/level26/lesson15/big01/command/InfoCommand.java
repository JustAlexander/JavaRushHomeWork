package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by kd130487pas on 12.02.16.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        boolean moneyAvailable = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            moneyAvailable = moneyAvailable|manipulator.hasMoney();
            if (manipulator.hasMoney())
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
        }
        if (!moneyAvailable)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
