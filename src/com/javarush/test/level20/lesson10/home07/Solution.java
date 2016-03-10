package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //in.defaultReadObject();
       // in.close();
        this.stream = new FileOutputStream((String) in.readObject(), true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution("/home/user/IdeaProjects/JavaRushHomeWork/f1");
        solution.stream.write("asd".getBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution newS = (Solution) inputStream.readObject();
        newS.stream.write("qwe".getBytes());
        fileInputStream.close();
        inputStream.close();
    }
}
