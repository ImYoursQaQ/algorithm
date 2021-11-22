package designpattern.creat.singletonpattern.pattern3;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 饱汉式单例模式 + 双检法
 *
 * @author teohubo
 */
public class IdGenerator {

    private final AtomicInteger id = new AtomicInteger(10000);

    private static IdGenerator instance = null;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    public int getId() {
        return id.incrementAndGet();
    }
}
