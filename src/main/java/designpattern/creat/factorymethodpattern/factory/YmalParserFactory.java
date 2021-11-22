package designpattern.creat.factorymethodpattern.factory;

import designpattern.creat.factorymethodpattern.parser.Parser;
import designpattern.creat.factorymethodpattern.parser.YmalParser;

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
