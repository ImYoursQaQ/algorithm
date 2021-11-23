package designpattern.struct.proxypattern;

/**
 * @author teohubo
 */
public class StaticProxy {


    static class Foo{

        public void car(){
            System.out.println("foo.car");
        }
    }

    /**
     * 静态代理实现1：使用继承
     */
    static class MyFoo extends Foo{

        @Override
        public void car() {
            System.out.println("myFoo.car");
            super.car();
        }
    }

    /**
     * 静态代理实现2：使用组合
     */
    static class MyFoo2 {
        public MyFoo2(Foo foo) {
            this.foo = foo;
        }

        private Foo foo;

        public void car() {
            System.out.println("myFoo2.car");
            this.foo.car();
        }
    }

    public static void main(String[] args) {
        MyFoo myFoo = new MyFoo();
        myFoo.car();

        MyFoo2 foo2 = new MyFoo2(new Foo());
        foo2.car();
    }
}
