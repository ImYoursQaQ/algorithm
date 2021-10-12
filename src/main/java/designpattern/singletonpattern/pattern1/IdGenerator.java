package designpattern.singletonpattern.pattern1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 饿汉式单例模式
 *
 * @author teohubo
 */
public class IdGenerator {

    private final AtomicInteger id = new AtomicInteger(10000);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public int getId(){
      return id.incrementAndGet();
    }
}
