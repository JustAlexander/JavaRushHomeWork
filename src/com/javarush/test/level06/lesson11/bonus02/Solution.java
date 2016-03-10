package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();
        Cat catGrandpa = new Cat(grandpaName);

        String grandmaName = reader.readLine();
        Cat catGrandma = new Cat(grandmaName);

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName, catGrandpa, null);

        String motherName = reader.readLine();
        Cat catMom = new Cat(motherName, null, catGrandma);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catDad, catMom);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catDad, catMom);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catDad);
        System.out.println(catMom);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat mom;
        private Cat dad;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat dad, Cat mom)
        {
            this.name = name;
            this.dad = dad;
            this.mom = mom;
        }

        @Override
        public String toString()
        {
            String s = "Cat name is " + name + ", ";

            if (mom == null)
                s = s + "no mother, ";
            else
                s = s + "mother is " + mom.name + ", ";
            if (dad == null)
                s = s + "no father";
            else
                s = s + "father is " + dad.name;

            return s;
        }
    }

}