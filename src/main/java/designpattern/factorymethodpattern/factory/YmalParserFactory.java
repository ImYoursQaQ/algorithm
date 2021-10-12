package designpattern.factorymethodpattern.factory;

import designpattern.factorymethodpattern.parser.Parser;
import designpattern.factorymethodpattern.parser.YmalParser;

/**
 * @author teohubo
 */
public class YmalParserFactory implements ParserFactory {
    /**
     * 生产parser实例
     *
     * @return
     */
    @Override
    public Parser getParser() {
        return new YmalParser();
    }
}
