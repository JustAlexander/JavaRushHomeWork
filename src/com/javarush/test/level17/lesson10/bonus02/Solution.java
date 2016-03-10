package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try
        {
            if (args[0].equals("-c"))
                createPerson(args);
            if (args[0].equals("-u"))
                updatePerson(args);
            if (args[0].equals("-d"))
                deletePerson(args);
            if (args[0].equals("-i"))
                infoPerson(args);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Нет аргументов");
        }
    }

    public synchronized static void createPerson(String[] args) {
        int i=1;
        try {
            while (i < args.length) {
                String name = args[i];
                Date bdp = null;
                try
                {
                    bdp = new SimpleDateFormat("dd/MM/yyyy").parse(args[i+2]);
                    if (args[i+1].equals("м")) {
                        allPeople.add(Person.createMale(name, bdp));
                        System.out.println(allPeople.size()-1);
                    }
                    else if (args[i+1].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(name, bdp));
                        System.out.println(allPeople.size() - 1);
                    }
                    else System.out.println("Не верный аргумент sex");
                }
                catch (ParseException e)
                {
                    System.out.println("Не верный аргумент db");
                }
                i += 3;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не хватает аргументов");
        }
    }

    public synchronized static void updatePerson(String[] args) {
        int i=1;
        try {
            while (i < args.length) {
                int id = Integer.parseInt(args[i]);
                if (id < 0){
                    System.out.println("id < 0");
                    return;
                }
                String name = args[i+1];
                Date bdp = null;
                try
                {
                    bdp = new SimpleDateFormat("dd/MM/yyyy").parse(args[i+3]);
                    if (args[i+2].equals("м")) {
                        allPeople.set(id, Person.createMale(name, bdp));
                    }
                    else if (args[i+2].equals("ж"))
                    {
                        allPeople.set(id, Person.createFemale(name, bdp));
                    }
                    else System.out.println("Не верный аргумент sex");
                }
                catch (ParseException e)
                {
                    System.out.println("Не верный аргумент db");
                }
                i += 4;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не хватает аргументов");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Не верный аргумент id");
        }
    }

    public synchronized static void deletePerson(String[] args) {
        int i=1;
        try {
            while (i < args.length) {
                try
                {
                    int id = Integer.parseInt(args[i]);
                    if (id < 0)
                    {
                        System.out.println("id < 0");
                        return;
                    }
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDay(null);
                }
                catch (NumberFormatException e) {
                    System.out.println("Не верный аргумент id");
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Нет такого элемента");
                }
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не хватает аргументов");
        }
    }

    public static void infoPerson(String[] args) {
        int i = 1;
        while (i < args.length) {
            try
            {
                int id = Integer.parseInt(args[i]);
                if (id < 0)
                {
                    System.out.println("id < 0");
                    return;
                }
                String sexStr = "";
                Sex sex = allPeople.get(id).getSex();
                if (sex == Sex.FEMALE)
                    sexStr = "ж";
                else if (sex == Sex.MALE)
                    sexStr = "м";
                SimpleDateFormat bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(allPeople.get(id).getName() + " " + sexStr + " " + bd.format(allPeople.get(id).getBirthDay()));
            }
            catch (NumberFormatException e) {
                System.out.println("Не верный аргумент id");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Нет такого элемента");
            }
            i++;
        }
    }
}
