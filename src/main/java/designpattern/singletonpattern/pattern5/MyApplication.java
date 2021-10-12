package designpattern.singletonpattern.pattern5;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author teohubo
 */
public class MyApplication {
    public static void main(String[] args) {
        IdGenerator instance = IdGenerator.INSTANCE;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->{
                System.out.println(instance.getId());
            });
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
