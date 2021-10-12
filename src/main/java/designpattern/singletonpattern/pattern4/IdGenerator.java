package designpattern.singletonpattern.pattern4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 静态内部类实现单例模式
 *
 * @author teohubo
 */
public class IdGenerator {

    private final AtomicInteger id = new AtomicInteger(10000);

    private IdGenerator() {
    }

    public static IdGenerator getInstance(){
        return inner.idGenerator;
    }


    public int getId() {
        return id.incrementAndGet();
    }

    private static class inner{
        private static final IdGenerator idGenerator = new IdGenerator();
    }
}
