package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable
{
    private static final long serialVersionUID = 123456789;

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        Solution sol = new Solution();
        Solution.B b = sol.new B("asd");
        outputStream.writeObject(b);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object object = inputStream.readObject();
        B oi = (B) object;
    }

    public static class A
    {
        protected String name = "A";
        public A() {}
        public A(String name)
        {
            this.name += name;
        }
    }

    public class B extends A implements Serializable
    {
        public B(String name)
        {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String) in.readObject();
        }
    }
}