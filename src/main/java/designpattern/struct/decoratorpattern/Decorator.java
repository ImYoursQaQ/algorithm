package designpattern.struct.decoratorpattern;

/**
 * @author teohubo
 */
public class Decorator {
    public static void main(String[] args) {
        WheatPizza wheatPizza = new WheatPizza();
        TomatoPizza tomatoPizza = new TomatoPizza(wheatPizza);
        System.out.println("The price of tomatoPizza is :"+tomatoPizza.getPrice());
    }
}

interface Pizza{

    int getPrice();
}

/**
 * 小麦面粉
 */
class WheatPizza implements Pizza{

    @Override
    public int getPrice() {
        return 10;
    }
}

/**
 * 加番茄酱
 */
class TomatoPizza implements Pizza{

    private final Pizza pizza;

    public TomatoPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return this.pizza.getPrice()+5;
    }
}