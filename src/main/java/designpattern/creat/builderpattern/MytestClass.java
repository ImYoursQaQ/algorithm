package designpattern.creat.builderpattern;

/**
 * @author teohubo
 */
public class MytestClass {

    public static void main(String[] args) {
        ConstructorArg.Builder builder = new ConstructorArg.Builder();
//        case1:
//        builder.isRef(true);
//          case 2:
        builder.isRef(false).type(String.class);
//        case3
//        builder.isRef(false).type(String.class).arg("ceshi");
        ConstructorArg build = builder.build();
        System.out.println(build.toString());
    }
}
