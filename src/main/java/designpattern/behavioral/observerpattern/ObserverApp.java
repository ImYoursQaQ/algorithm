package designpattern.behavioral.observerpattern;

import com.google.common.collect.Lists;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author teohubo
 *
 * 利用 Google Guava EventBus 实现进程内的观察者模式，支持同步和异步，不常用
 * springboot 应用建议使用 Spring 事件，【不建议】
 * 建议直接使用进程间的基于MQ的观察着实现【建议】
 */
public class ObserverApp {

    public static void main(String[] args) {
        User user = new User(1);
        Credit credit = new Credit();
        user.setObservers(Lists.newArrayList(credit));
        user.login();
    }

}

class User{

    private EventBus eventBus;

    private Integer id;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public User(Integer id) {
        this.id = id;
        // 异步非阻塞模式;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setObservers(List<Object> observers){
        observers.forEach(o -> eventBus.register(o));
    }

    public void login(){
        System.out.println("user login success,userId:"+this.id);
        eventBus.post(this.id);
    }
}

class Credit{

    @Subscribe
    public void handlerLoginSuccess(Integer userId){
        System.out.println("user Credit add,userId:"+userId);
    }

}
