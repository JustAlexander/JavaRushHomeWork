package com.javarush.test.level17.lesson10.bonus01;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (badArgs(args))
            return;
        if (work(args) == false)
            return;
    }

    public static boolean work(String[] args) {
        try
        {

            if (args.length == 2)
                proccess(args[0], Integer.parseInt(args[1]));
            if (args.length == 4) {
                if (args[0].equals("-c"))
                    proccess(args[1], args[2], args[3]);
                else System.out.println("Ожидается -с");
            }
            if (args.length == 5) {
                if (args[0].equals("-u"))
                    proccess(Integer.parseInt(args[1]), args[2], args[3], args[4]);
                else System.out.println("Ожидается -с");
            }

        }
        catch (NumberFormatException e)
        {
            System.out.println("Неверные параметры");
        }
        return true;
    }

    public static void proccess(String arg, int id) {
        try
        {
            if (arg.equals("-i"))
            {                 //инфа по челу
                String sexStr = "";
                Sex sex = allPeople.get(id).getSex();
                if (sex == Sex.FEMALE)
                    sexStr = "ж";
                else if (sex == Sex.MALE)
                    sexStr = "м";
                SimpleDateFormat bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(allPeople.get(id).getName() + " " + sexStr + " " + bd.format(allPeople.get(id).getBirthDay()));
            }
            if (arg.equals("-d"))
            {                 //удаление
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Нет такого id");
        }
    }

    public static void proccess(String name, String sex, String bd) {
        Date bdp = null;
        try
        {
            bdp = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        }
        catch (ParseException e)
        {
            System.out.println("Не верный аргумент db");
        }
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, bdp));
            System.out.println(allPeople.size()-1);
        }
        else if (sex.equals("ж"))
        {
            allPeople.add(Person.createFemale(name, bdp));
            System.out.println(allPeople.size() - 1);
        }
        else System.out.println("Не верный аргумент sex");
    }

    public static void proccess(int id, String name, String sex, String bd) {
        Date bdp = null;
        try
        {
            bdp = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        }
        catch (ParseException e)
        {
            System.out.println("Не верный аргумент db");
        }
        if (sex.equals("м"))
            allPeople.set(id, Person.createMale(name, bdp));
        else if (sex.equals("ж"))
            allPeople.set(id, Person.createFemale(name, bdp));
        else System.out.println("Не верный аргумент sex");
    }

    private static boolean badArgs(String[] args) {
        if (args.length != 2 && args.length != 4 && args.length != 5)
            return true;
        if (!args[0].equals("-c") && !args[0].equals("-u") && !args[0].equals("-d") && !args[0].equals("-i"))
            return true;
        if (args.length == 2)
        {
            if (!args[0].equals("-d") && !args[0].equals("-i"))
                return true;
            try
            {
                if (Integer.parseInt(args[1]) < 0)
                    return true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Не верный аргумент id");
            }
        }
        return false;
    }
}
