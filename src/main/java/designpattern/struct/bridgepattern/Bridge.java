package designpattern.struct.bridgepattern;

/**
 * @author teohubo
 */
public class Bridge {
    public static void main(String[] args) {
        Mac mac = new Mac();
        Epson epson = new Epson();
        Win win = new Win();
        Hp hp = new Hp();
        //mac  使用 epson 打印；
        mac.setPrinter(epson);
        mac.print();

        //mac  使用 Hp 打印
        mac.setPrinter(hp);
        mac.print();

        //win  使用 epson 打印；
        win.setPrinter(epson);
        win.print();

        //win  使用 Hp 打印
        win.setPrinter(hp);
        win.print();
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
interface Printer{

    void printFile();
}

interface Computer{

     void print();
     void setPrinter(Printer printer);
}

class Epson implements Printer{

    @Override
    public void printFile() {
        System.out.println("Epson.printFile");
    }
}

class Hp implements Printer{

    @Override
    public void printFile() {
        System.out.println("Hp.printFile");
    }
}

class Win implements Computer{

    private Printer printer;

    @Override
    public void print() {
        System.out.println("win.print");
        this.printer.printFile();
    }

    @Override
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}

class Mac implements Computer{

    private Printer printer;

    @Override
    public void print() {
        System.out.println("mac.print");
        this.printer.printFile();
    }

    @Override
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}

