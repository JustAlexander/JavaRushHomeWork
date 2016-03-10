package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by user on 31.01.15.
 */
public class Hippodrome {
    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horse1 = new Horse("Стрела", 3, 0);
        Horse horse2 = new Horse("Дымка", 3, 0);
        Horse horse3 = new Horse("Рысь", 3, 0);
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);
        game.run();
        game.printWinner();
    }

    public static Hippodrome game;

    static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = null;
        double dis = 0;
        for (Horse horse : getHorses()) {
            if (horse.distance > dis) {
                winner = horse;
                dis = horse.distance;
            }
        }
        if (winner != null)
            return winner;
        return null;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
