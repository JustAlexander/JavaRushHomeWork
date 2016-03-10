package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by kd130487pas on 10.02.16.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String s = reader.readLine();
            if (s.toUpperCase().equals(res.getString("operation.EXIT")))
                throw new InterruptOperationException();
            return s;
        } catch (IOException e) {
        }
        return "";
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code;
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            code = readString().trim();
            if (code.length() == 3)
                return code.toUpperCase();
            else
                writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] strings;
        String string;
        while (true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            string = readString();
            strings = string.trim().split(" ");
            if (strings.length == 2) {
                try {
                    int denomination = Integer.parseInt(strings[0]);
                    int number = Integer.parseInt(strings[1]);
                    if (denomination >= 0 && number >= 0)
                        return strings;
                    else writeMessage(res.getString("invalid.data"));
                } catch (NumberFormatException e) {
                    writeMessage(res.getString("invalid.data"));
                }
            }
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        try {
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        }
        catch (IllegalArgumentException e) {
            writeMessage(res.getString("invalid.data"));
            return askOperation();
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
