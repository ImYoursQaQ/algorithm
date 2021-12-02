package designpattern.struct.flyweightpattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author teohubo
 *
 * 使用场景：
 * 当一个系统中存在大量重复对象的时候，如果这些重复的对象是不可变对象，我们就可以利用享元模式将对象设计成享元，在内存中只保留一份实例，供多处代码引用。
 * 这样可以减少内存中对象的数量，起到节省内存的目的。
 * 实际上，不仅仅相同对象可以设计成享元，对于相似对象，我们也可以将这些对象中相同的部分（字段）提取出来，设计成享元，让这些大量相似对象引用这些享元。
 */
public class FlyWeightApplication {

    public static void main(String[] args) {

        Game game = new Game();

        Player t1 = new Player("T",0,0 );
        Player t2 = new Player("T",1,1 );

        Player ct1 = new Player("CT",100,100 );
        Player ct2 = new Player("CT",101,101 );

        game.addT(t1);
        game.addT(t2);
        game.addCT(ct1);
        game.addCT(ct2);
        game.start();

    }

}

interface Dress{

    String getColor();

}

class TerroristDress implements Dress{

    @Override
    public String getColor() {
        return "BLACK";
    }
}

class CTDress implements Dress{


    @Override
    public String getColor() {
        return "RED";
    }
}

class DressFactory{

    static Map<String,Dress> dressMap = new HashMap<>();

    static {
        dressMap.put("T",new TerroristDress());
        dressMap.put("CT",new CTDress());
    }

    public Dress getDressByType(String type){
        return dressMap.get(type);
    }
}

@Getter
class Player{

    static DressFactory dressFactory = new DressFactory();

    private Dress dress;

    private String type;

    private Integer lat;

    private Integer log;

    public Player(String type, Integer lat, Integer log) {
        this.type = type;
        this.dress = dressFactory.getDressByType(type);
        this.lat = lat;
        this.log = log;
    }
}

class Game{
    List<Player> t = new ArrayList<>();

    List<Player> ct = new ArrayList<>();

    public void addT(Player player){
        this.t.add(player);
    }

    public void addCT(Player player) {
        this.ct.add(player);
    }

    public void start(){
        t.forEach(player -> System.out.println(player.getDress()));
        ct.forEach(player -> System.out.println(player.getDress()));
    }
}
