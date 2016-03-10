package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by kd130487pas on 12.02.16.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
