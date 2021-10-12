package designpattern.simplefactorypattern;


import designpattern.simplefactorypattern.parser.Parser;

/**
 * @author teohubo
 */
public class MyApplication {

    public static void main(String[] args) {
        ParserFactorys parserFactorys = new ParserFactorys();
        Parser parser = parserFactorys.getParser("key");
        parser.parse("text");
    }
}
