package com.javarush.test.level20.lesson02.task01;

import java.io.*;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        writer.print(name);
        writer.println("<separ>" + getPrice());
        writer.flush();
    }
}
