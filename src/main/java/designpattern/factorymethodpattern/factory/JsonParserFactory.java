package designpattern.factorymethodpattern.factory;

import designpattern.factorymethodpattern.parser.JsonParser;
import designpattern.factorymethodpattern.parser.Parser;

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
