package designpattern.creat.factorymethodpattern.factory;

import designpattern.creat.factorymethodpattern.parser.Parser;

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
