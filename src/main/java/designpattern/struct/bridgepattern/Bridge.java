package designpattern.struct.bridgepattern;

/**
 * @author teohubo
 */
public class Bridge {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Brand apple = new Brand("APPLE");
        iphone.setBrand(apple);
    }
}

/**
 * 一个类存在两个（或多个）独立变化的维度，我们通过组合的方式，让这两个（或多个）维度可以独立进行扩展。”通过组合关系来替代继承关系，避免继承层次的指数级爆炸
 * 使用继承 M*N
 * 使用组合 M+N
 * 那么这种模式只有M+N个类就可以描述所有类型，这就是M*N的继承类爆炸简化成了M+N组合
 *
 * 一个类存在不同纬度的变化，可以通过组合的方式，让它们独自扩展。
 * 栗子：白色圆形，白色正方形，黑色圆形，黑色正方形。 抽象成 颜色 跟 形状 两个纬度去搞，就是桥接模式啦。
 */
abstract class AbstractPhone{

    protected Brand brand;

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

class Brand{

    private String name;

    public Brand(String name) {
        this.name = name;
    }
}

class Iphone extends AbstractPhone{


    @Override
    public void setBrand(Brand brand) {
        super.setBrand(brand);
    }
}
