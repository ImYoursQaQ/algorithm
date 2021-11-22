package designpattern.creat.factorymethodpattern;

import designpattern.creat.factorymethodpattern.parser.Parser;

/**
 * @author teohubo
 */
public class MyApplication {

    public static void main(String[] args) {
        Parser parser = ParserFactorys.getFactory("json").getParser();
        parser.parse("text");
    }
}
