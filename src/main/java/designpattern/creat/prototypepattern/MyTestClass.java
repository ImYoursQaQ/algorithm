package designpattern.creat.prototypepattern;

/**
 * @author teohubo
 */
public class MyTestClass {

    public static void main(String[] args) {

        DataCenter dataCenter = new DataCenter();
        dataCenter.init();
        String key = "english";
        System.out.println(dataCenter.getScore(key));

        dataCenter.update();
        System.out.println(dataCenter.getScore(key));
    }
}
