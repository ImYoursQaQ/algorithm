package leetCode.strings;

/**
 * @author teohubo
 */
public class Solution125 {

    /**
     * 利用正则表达式 过滤非法字符
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        String before = s.trim().toLowerCase().replaceAll("[^a-z0-9]", "");
        String after = new StringBuilder(before).reverse().toString();
        return before.equals(after);
    }
}
