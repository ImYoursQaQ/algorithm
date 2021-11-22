package designpattern.creat.builderpattern;

import joptsimple.internal.Strings;

import java.util.Objects;
import java.util.Optional;

/**
 * @author teohubo
 */
public class ConstructorArg {

    private boolean isRef;

    private Class type;

    private Object arg;

    private ConstructorArg(boolean isRef, Class type, Object arg) {
        this.isRef = isRef;
        this.type = type;
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "ConstructorArg{" +
                "isRef=" + isRef +
                ", type=" + type +
                ", arg=" + arg +
                '}';
    }


    static class Builder{

        private boolean isRef;

        private Class type;

        private Object arg;

        public Builder isRef(boolean isRef){
            this.isRef = isRef;
            return this;
        }

        public Builder type(Class clazz){
            this.type = clazz;
            return this;
        }

        public Builder arg(String arg){
            this.arg = arg;
            return this;
        }

        public ConstructorArg build(){
            if (this.isRef){
                String s = Optional.ofNullable(this.arg).map(Object::toString).orElse("");
                if (Strings.isNullOrEmpty(s)){
                    throw new RuntimeException("error arg");
                }
            }
            if (!this.isRef){
                if (Objects.isNull(this.type)){
                    throw new RuntimeException("no type");
                }
                if (Objects.isNull(this.arg)){
                    throw new RuntimeException("no arg");
                }
            }
            return new ConstructorArg(this.isRef,this.type,this.arg);
        }
    }
}
