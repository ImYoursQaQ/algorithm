package designpattern.creat.factorymethodpattern.factory;

import designpattern.creat.factorymethodpattern.parser.JsonParser;
import designpattern.creat.factorymethodpattern.parser.Parser;

/**
 * @author teohubo
 */
public class JsonParserFactory implements ParserFactory {

    /**
     * 生产parser实例
     *
     * @return
     */
    @Override
    public Parser getParser() {
        return new JsonParser();
    }
}
