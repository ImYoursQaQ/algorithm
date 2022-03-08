package leetCode.strings;

/**
 * @author teohubo
 * 最长回文子串
 */
public class Solution5 {

    /**
     * 滑动窗口问题：暴力法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)){
            return "";
        }
        int length = s.length();
        for (int i = length; i > 0 ; i--) {
            for (int j = 0; j < length - i + 1; j++) {
                String sub = s.substring(j,j+i);
                if (isPalindrome(sub)){
                    return sub;
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String sub) {
        String after = new StringBuilder(sub).reverse().toString();
        return sub.equalsIgnoreCase(after);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("a"));

    }
}
