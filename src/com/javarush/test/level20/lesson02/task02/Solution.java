package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("/home/user/IdeaProjects/JavaRushHomeWork/f1");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("Abdul");
            javaRush.users.get(0).setLastName("Ivanov");
            javaRush.users.get(0).setMale(true);
            String string_date = "12-08-1985";
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            Date d = f.parse(string_date);
            javaRush.users.get(0).setBirthDate(d);
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.users.add(new User());
            javaRush.users.get(1).setFirstName("Иван");
            javaRush.users.get(1).setLastName("Петров");
            javaRush.users.get(1).setMale(false);
            string_date = "09-12-1999";
            d = f.parse(string_date);
            javaRush.users.get(1).setBirthDate(d);
            javaRush.users.get(1).setCountry(User.Country.OTHER);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.users.get(0).getFirstName());
            System.out.println(loadedObject.users.get(0).getFirstName());
            System.out.println(javaRush.users.get(0).getLastName());
            System.out.println(loadedObject.users.get(0).getLastName());
            System.out.println(javaRush.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(0).getBirthDate());
            System.out.println(javaRush.users.get(0).getCountry());
            System.out.println(loadedObject.users.get(0).getCountry());
            System.out.println(javaRush.users.get(0).isMale());
            System.out.println(loadedObject.users.get(0).isMale());
            System.out.println(javaRush.users.get(1).getFirstName());
            System.out.println(loadedObject.users.get(1).getFirstName());
            System.out.println(javaRush.users.get(1).getLastName());
            System.out.println(loadedObject.users.get(1).getLastName());
            System.out.println(javaRush.users.get(1).getBirthDate());
            System.out.println(loadedObject.users.get(1).getBirthDate());
            System.out.println(javaRush.users.get(1).getCountry());
            System.out.println(loadedObject.users.get(1).getCountry());
            System.out.println(javaRush.users.get(1).isMale());
            System.out.println(loadedObject.users.get(1).isMale());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            writer.flush();
            for (User user : users) {
                user.save(outputStream);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++) {
                users.add(new User());
                if (reader.readLine().equals("yes"))
                    users.get(i).setFirstName(reader.readLine());
                if (reader.readLine().equals("yes"))
                    users.get(i).setLastName(reader.readLine());
                if (reader.readLine().equals("yes"))
                    users.get(i).setBirthDate(new Date(Long.parseLong(reader.readLine())));
                users.get(i).setMale(Boolean.parseBoolean(reader.readLine()));
                if (reader.readLine().equals("yes")) {
                    String country = reader.readLine();
                    if (country.equals("Other"))
                        users.get(i).setCountry(User.Country.OTHER);
                    if (country.equals("Russia"))
                        users.get(i).setCountry(User.Country.RUSSIA);
                    if (country.equals("Ukraine"))
                        users.get(i).setCountry(User.Country.UKRAINE);
                }
            }
            reader.close();
        }
    }
}
