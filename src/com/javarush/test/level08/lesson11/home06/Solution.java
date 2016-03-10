package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        Human d1 = new Human("Игорь", true, 16);
        Human d2 = new Human("Маша", false, 14);
        Human d3 = new Human("Света", false, 12);
        Human r1 = new Human("Папа Рома", true, 40, d1, d2, d3);
        Human r2 = new Human("Мама Оля", false, 38, d1, d2, d3);
        Human ba = new Human("Баба Катя", false, 70, r1, r2);
        Human de = new Human("Дед Ваня", true, 75, r1, r2);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(de);
        System.out.println(ba);
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, Human... kids)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            Collections.addAll(this.children, kids);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}