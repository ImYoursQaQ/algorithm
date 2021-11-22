package designpattern.creat.singletonpattern.pattern2;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 饱汉式单例模式
 *
 * @author teohubo
 */
public class IdGenerator {

    private final AtomicInteger id = new AtomicInteger(10000);

    private static IdGenerator instance = null;

    private IdGenerator() {
    }

    public static synchronized IdGenerator getInstance() {
        if (Objects.isNull(instance)){
            instance = new IdGenerator();
        }
        return instance;
    }

    public int getId(){
      return id.incrementAndGet();
    }
}
