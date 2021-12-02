package designpattern.struct.flyweightpattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author teohubo
 */
public class FlyWeightApplication {

    public static void main(String[] args) {

        Game game = new Game();

        DressFactory dressFactory = new DressFactory();
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
