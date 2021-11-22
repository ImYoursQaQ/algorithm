package designpattern.creat.factorymethodpattern;

import designpattern.creat.factorymethodpattern.factory.JsonParserFactory;
import designpattern.creat.factorymethodpattern.factory.ParserFactory;
import designpattern.creat.factorymethodpattern.factory.XmlParserFactory;
import designpattern.creat.factorymethodpattern.factory.YmalParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author teohubo
 */
public class ParserFactorys {

    private static Map<String, ParserFactory> factoryMap;


    static  {
        HashMap<String, ParserFactory> map = new HashMap<>();
        map.put("json",new JsonParserFactory());
        map.put("xml",new XmlParserFactory());
        map.put("ymal",new YmalParserFactory());
        factoryMap = map;
    }

    public static ParserFactory getFactory(String key){
        return factoryMap.get(key);
    }
}
