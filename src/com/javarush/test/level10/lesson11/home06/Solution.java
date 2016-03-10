package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String name;
        public int age;
        public int weigth;
        public boolean sex;
        public boolean married;
        public Human spouse;

        public Human()
        {
            name = "Human";
            age = 0;
            weigth = 0;
            sex = true;
            married = false;
            spouse = null;
        }

        public Human(String name)
        {
            this.name = name;
            age = 0;
            weigth = 0;
            sex = true;
            married = false;
            spouse = null;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
            weigth = 0;
            sex = true;
            married = false;
            spouse = null;
        }

        public Human(String name, int age, int weigth)
        {
            this.name = name;
            this.age = age;
            this.weigth = weigth;
            sex = true;
            married = false;
            spouse = null;
        }

        public Human(String name, int age, int weigth, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.weigth = weigth;
            this.sex = sex;
            married = false;
            spouse = null;
        }

        public Human(String name, int age, int weigth, boolean sex, Human spouse)
        {
            this.name = name;
            this.age = age;
            this.weigth = weigth;
            this.sex = sex;
            married = true;
            this.spouse = spouse;
        }

        public Human(String name, int age, int weigth, Human spouse)
        {
            this.name = name;
            this.age = age;
            this.weigth = weigth;
            if (spouse.sex)
                sex = false;
            else
                sex = true;
            married = true;
            this.spouse = spouse;
        }

        public Human(String name, int weigth, Human spouse)
        {
            this.name = name;
            age = 18;
            this.weigth = weigth;
            if (spouse.sex)
                sex = false;
            else
                sex = true;
            married = true;
            this.spouse = spouse;
        }

        public Human(String name, Human spouse)
        {
            this.name = name;
            age = 18;
            weigth = 50;
            if (spouse.sex)
                sex = false;
            else
                sex = true;
            married = true;
            this.spouse = spouse;
        }

        public Human(Human spouse)
        {
            this.name = "Married human";
            age = 18;
            weigth = 50;
            if (spouse.sex)
                sex = false;
            else
                sex = true;
            married = true;
            this.spouse = spouse;
        }

    }
}
