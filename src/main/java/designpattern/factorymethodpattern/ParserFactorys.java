package designpattern.factorymethodpattern;

import designpattern.factorymethodpattern.factory.JsonParserFactory;
import designpattern.factorymethodpattern.factory.ParserFactory;
import designpattern.factorymethodpattern.factory.XmlParserFactory;
import designpattern.factorymethodpattern.factory.YmalParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author teohubo
 */
public class ParserFactorys {

    Map<String, ParserFactory> factoryMap;


    public ParserFactorys() {
        HashMap<String, ParserFactory> map = new HashMap<>();
        map.put("json",new JsonParserFactory());
        map.put("xml",new XmlParserFactory());
        map.put("ymal",new YmalParserFactory());
        factoryMap = map;
    }

    public ParserFactory getFactory(String key){
        return factoryMap.get(key);
    }
}