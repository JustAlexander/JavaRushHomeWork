package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
    {
        System.out.println(new Solution(4));
        Solution solution = new Solution(5);
        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        System.out.println(solution);
        fileOutputStream.close();
        outputStream.close();
        Thread.sleep(1000);
        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object o = inputStream.readObject();
        Solution newSol = (Solution)o;
        fileInputStream.close();
        inputStream.close();
        System.out.println(newSol);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
