package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(speed++);
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
    {
        System.out.println("Begin:");
        Solution solution = new Solution(500);
        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        Thread.sleep(1000);

        solution.runner.interrupt();
        outputStream.writeObject(solution);
        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution newSol = (Solution) inputStream.readObject();

        Thread.sleep(1000);
        newSol.runner.interrupt();
    }
}
