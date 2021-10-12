package designpattern.factorymethodpattern.factory;

import designpattern.factorymethodpattern.parser.Parser;

/**
 * @author teohubo
 */
public interface ParserFactory {

    /**
     * 生产parser实例
     * @return
     */
    Parser getParser();
}
