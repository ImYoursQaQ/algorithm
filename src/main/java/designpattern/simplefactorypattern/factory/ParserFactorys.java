package designpattern.simplefactorypattern.factory;

import designpattern.simplefactorypattern.parser.JsonParser;
import designpattern.simplefactorypattern.parser.Parser;
import designpattern.simplefactorypattern.parser.XmlParser;
import designpattern.simplefactorypattern.parser.YmalParser;

import java.util.Objects;

/**
 * @author teohubo
 */
public class ParserFactorys {

    public Parser getParser(String key){
        if (Objects.equals(key,"json")){
            return new JsonParser();
        }
        if (Objects.equals(key,"xml")){
            return new XmlParser();
        }
        if (Objects.equals(key,"ymal")){
            return new YmalParser();
        }
        return null;
    }
}
