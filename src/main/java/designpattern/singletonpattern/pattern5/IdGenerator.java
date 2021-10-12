package designpattern.singletonpattern.pattern5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用枚举构建单例模式
 *
 * @author teohubo
 */
public enum IdGenerator {

    /**
     *
     */
    INSTANCE;

    private AtomicInteger id = new AtomicInteger(10000);

    public  int getId(){
        return id.incrementAndGet();
    }
}
