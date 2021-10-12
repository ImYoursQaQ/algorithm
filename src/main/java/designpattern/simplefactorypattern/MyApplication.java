package designpattern.simplefactorypattern;


import designpattern.simplefactorypattern.parser.Parser;

/**
 * @author teohubo
 */
public class MyApplication {

    public static void main(String[] args) {
        Parser parser = ParserFactorys.getParser("key");
        parser.parse("text");
    }
}
