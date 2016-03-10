package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Дедушка Игорь", true, 80);
        Human ded2 = new Human("Дедушка Паша", true, 78);
        Human ba1 = new Human("Бабушка Анна", false, 76);
        Human ba2 = new Human("Бабушка Ира", false, 74);
        Human otec = new Human("Отец Рома", true, 45, ded1, ba1);
        Human mat = new Human("Мать Юля", false, 40, ded2, ba2);
        Human reb1 = new Human("Сашенька", true, 18, otec, mat);
        Human reb2 = new Human("Машенька", false, 16, otec, mat);
        Human reb3 = new Human("Дашенька", false, 14, otec, mat);

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(ba1.toString());
        System.out.println(ba2.toString());
        System.out.println(otec.toString());
        System.out.println(mat.toString());
        System.out.println(reb1.toString());
        System.out.println(reb2.toString());
        System.out.println(reb3.toString());
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
