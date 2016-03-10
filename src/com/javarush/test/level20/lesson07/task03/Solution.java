package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("asda", "fasdf", 15);
        Person p1 = new Person("p1", "pp1", 16);
        Person p2 = new Person("p2", "pp2", 17);
        person.setFather(p1);
        person.setMother(p2);
        List<Person> children = new ArrayList<>();
        children.add(person);
        p1.setChildren(children);
        p2.setChildren(children);
        FileOutputStream fileOutputStream = new FileOutputStream("person.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(person);
        fileOutputStream.close();
        outputStream.close();
        System.out.println(person);
        FileInputStream fileInputStream = new FileInputStream("person.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        person = (Person) inputStream.readObject();
        fileInputStream.close();
        inputStream.close();
        System.out.println(person);
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            Object f = in.readObject();
            if (f!=null)
                father = (Person)f;
            Object m = in.readObject();
            if (m!=null)
                mother = (Person)m;
            Object c = in.readObject();
            if (c!=null)
                children = (List)c;
        }
    }
}
