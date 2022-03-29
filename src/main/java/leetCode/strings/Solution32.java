package leetCode.strings;

/**
 * @author teohubo
 */
public class Solution32 {

    /**
     * 最长有效括号
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if ( s == null || "".equals(s)){
            return 0;
        }

        int res = 0;
        String tmp = s;
        while (tmp.contains("()")){
            res += 2;
           tmp = tmp.replaceFirst("\\(\\)","");
        }
        return res;
    }


    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("()()()"));
    }
}
