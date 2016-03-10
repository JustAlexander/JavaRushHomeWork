package com.javarush.test.level20.lesson02.task02;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        if (firstName != null) {
            writer.println("yes");
            writer.println(firstName);
        }
        else writer.println("no");
        if (lastName != null) {
            writer.println("yes");
            writer.println(lastName);
        }
        else writer.println("no");
        if (birthDate != null) {
            writer.println("yes");
            writer.println(birthDate.getTime());
        }
        else writer.println("no");
        writer.println(isMale);
        if (country != null) {
            writer.println("yes");
            writer.println(country.getDisplayedName());
        }
        else writer.println("no");
        writer.flush();
    }
}
