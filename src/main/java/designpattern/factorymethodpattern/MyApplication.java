package designpattern.factorymethodpattern;

import designpattern.factorymethodpattern.parser.Parser;

/**
 * @author teohubo
 */
public class MyApplication {

    public static void main(String[] args) {
        ParserFactorys parserFactorys = new ParserFactorys();
        Parser parser = parserFactorys.getFactory("json").getParser();
        parser.parse("text");
    }
}
