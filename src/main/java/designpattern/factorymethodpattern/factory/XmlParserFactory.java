package designpattern.factorymethodpattern.factory;

import designpattern.factorymethodpattern.parser.Parser;
import designpattern.factorymethodpattern.parser.XmlParser;

/**
 * @author teohubo
 */
public class XmlParserFactory implements ParserFactory {
    /**
     * 生产parser实例
     *
     * @return
     */
    @Override
    public Parser getParser() {
        return new XmlParser();
    }
}
