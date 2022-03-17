package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  交替打印abc
 *
 * 参考：https://blog.csdn.net/hefenglian/article/details/82596072
 */
public class MyApp {

    private final AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = Integer.MAX_VALUE;

    private class RunnableA implements Runnable {
        @Override
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 0) {
                    System.out.print("A");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {
        @Override
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1) {
                    System.out.print("B");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {
        @Override
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2) {
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }

        }
    }


    public static void main(String[] args) {
        MyApp atomic_ABC = new MyApp();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(atomic_ABC.new RunnableA());
        service.execute(atomic_ABC.new RunnableB());
        service.execute(atomic_ABC.new RunnableC());

        service.shutdown();
    }
}


