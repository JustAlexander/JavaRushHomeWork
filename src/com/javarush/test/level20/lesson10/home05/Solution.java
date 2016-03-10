package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("asdf", "afqwer", "gdfg", Sex.FEMALE);
        System.out.println(person.greetingString + person.fullName + " " + person.sex + " " + person.logger + " " + person.outputStream + " " + person.country);
        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(person);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Person newPer = (Person) inputStream.readObject();
        System.out.println(newPer.greetingString + newPer.fullName + " " + newPer.sex + " " + newPer.logger + " " + newPer.outputStream + " " + newPer.country);
        fileInputStream.close();
        inputStream.close();
    }
}
