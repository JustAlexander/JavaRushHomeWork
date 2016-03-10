package com.javarush.test.level25.lesson07.home01;

import java.io.InterruptedIOException;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private String threadName;
    private Thread thread;

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                System.out.println(threadName);
                Thread.sleep(110);
            }
        }
        catch (InterruptedException e) {

        }
    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

}
