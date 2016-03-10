package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Apartment apartment = new Apartment();
        System.out.println(apartment);
        FileOutputStream fileOutputStream = new FileOutputStream("out.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(apartment);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("out.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object newApatment = inputStream.readObject();
        Apartment nApat = (Apartment)newApatment;
        fileInputStream.close();
        inputStream.close();
        System.out.println(nApat);
    }

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {

                out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            String a = (String) in.readObject();

                address = a;
            year = in.readInt();
        }
    }
}
