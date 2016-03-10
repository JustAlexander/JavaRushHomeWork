package com.javarush.test.level25.lesson05.task02;

/* Без дураков
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды,
а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...). Пример:
super secret key, Thread-0, it's an example
2. Разберитесь в последовательности выполняемого кода и обеспечьте логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new Solution().new MyThread("super secret key");
        System.out.println("sleeping 1000...");
        myThread.start();

    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s, %s, %s", secretKey, thread.getName(), throwable.getMessage()));
            }
        }
    }

}

