package leetCode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hubo
 * @date 2020-07-31
 * @description:
 */

/**
 * 22.括号生成
 */
public class Solution2 {

    public  List<String> generateParenthesis(int n) {
        if (n == 0){
            return Collections.EMPTY_LIST;
        }
        List<String> list = new ArrayList<>();
        String str = "";
        doGenerate(list,str,n,n);
        return list;
    }

    private  void doGenerate(List<String> list, String str, int nLeft, int nRight) {
        if (nLeft == 0 && nRight == 0){
            list.add(str);
            return;
        }
        if (nLeft>0){
            doGenerate(list,str+"(",nLeft-1,nRight);
        }
        if (nRight>nLeft){
            doGenerate(list,str+")",nLeft,nRight-1);
        }
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(s.substring(0,1));
        System.out.println(s.substring(1,2));
       // generateParenthesis(2);
    }

}
