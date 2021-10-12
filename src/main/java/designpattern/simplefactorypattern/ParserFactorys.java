package designpattern.simplefactorypattern;

import designpattern.simplefactorypattern.parser.JsonParser;
import designpattern.simplefactorypattern.parser.Parser;
import designpattern.simplefactorypattern.parser.XmlParser;
import designpattern.simplefactorypattern.parser.YmalParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author teohubo
 */
public class ParserFactorys {

    private static final Map<String,Parser> cacheParsers;

    static {
        Map<String,Parser> map = new HashMap<>();
        map.put("json",new JsonParser());
        map.put("xml",new XmlParser());
        map.put("ymal",new YmalParser());
        cacheParsers = map;
    }

    public static Parser getParser(String key){
        return cacheParsers.get(key);
    }
}
