package nowcoder.array;



import java.util.ArrayList;
import java.util.List;

/**
 * @author hubo
 * @date 2020-06-10
 * @description:
 */

/**
 * 替换空格
 */
public class Class3 {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("we are happy");
        String s = replaceSpace2(stringBuffer);
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str) {
        String replace = str.toString().replace(" ", "%20");
        return replace;
    }

    public static String replaceSpace2(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        Character blank = new Character((char) 32);
        List target = new ArrayList();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == blank ){
                target.add("%20");
            }
            else {
                target.add(chars[i]);
            }
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < target.size(); i++) {
            stringBuffer.append(target.get(i));
        }
        return stringBuffer.toString();
    }
}
