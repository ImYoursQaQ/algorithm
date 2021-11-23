package designpattern.struct.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author teohubo
 */
public class DynamicProxy {

    public static void main(String[] args) {
        Class[] classes = new Class[]{Hello.class};
        Object proxy = Proxy.newProxyInstance(Foo.class.getClassLoader(), classes, new MyInvokeHandler(new Foo()));
        Hello hello = (Hello) proxy;
        hello.car();
    }

}

interface Hello {
    void car();
}

class Foo implements Hello {

    @Override
    public void car() {
        System.out.println("foo.car");
    }
}

/**
 * 基于JDK动态代理的实现，对目标类的方法进行增强
 */
class MyInvokeHandler implements InvocationHandler {

    private Object target;

    public MyInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvokeHandler.car");
        return method.invoke(target,args);
    }
}

