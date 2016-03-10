package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        while (true) {
            Rectangle rectangle = getRectangle(a);
            if (rectangle == null)
                return count;
            a = clearRectangle(rectangle, a);
            count++;
        }
    }

    public static Rectangle getRectangle(byte[][] a) {
        Boolean found = false;
        int width = 0;
        int height = 0;
        Coord begin = new Coord(-1, -1);
        Coord end = new Coord(-1, -1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (found && a[i][j] == 0)
                    break;
                if (a[i][j] == 1) {
                    found = true;
                    width++;
                    if (begin.x == -1)
                        begin.x = j;
                    end.x = j;
                }
            }
            if (width > 0) {
                begin.y = i;
                break;
            }
        }
        if (!found)
            return null;
        found = false;
        for (int i = begin.x; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (found && a[j][i] == 0)
                    break;
                if (a[j][i] == 1) {
                    found = true;
                    height++;
                    end.y = j;
                }
            }
            if (height > 0)
                break;
        }

        for (int i = begin.y; i <= end.y; i++) {
            for (int j = begin.x; j <= end.x; j++) {
                if (a[i][j] != 1)
                    return null;
            }
        }
        return new Rectangle(begin, end, width, height);
    }

    public static byte[][] clearRectangle(Rectangle r, byte[][] a) {
        for (int i = r.b.y; i <= r.e.y; i++) {
            for (int j = r.b.x; j <= r.e.x; j++) {
                a[i][j] = 0;
            }
        }
        return a;
    }
    
    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class Rectangle {
        Coord b, e;

        public Rectangle(Coord b, Coord e, int width, int height) {
            this.b = b;
            this.e = e;
            this.width = width;
            this.height = height;
        }

        int width, height;
    }
}
