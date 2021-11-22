package designpattern.creat.singletonpattern.pattern2;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author teohubo
 */
public class MyApplication {
    public static void main(String[] args) {
        IdGenerator instance = IdGenerator.getInstance();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->{
                System.out.println(instance.getId());
            });
        }
    }
}
