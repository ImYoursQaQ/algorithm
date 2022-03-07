package leetCode.strings;

/**
 * @author teohubo
 */
public class Solution14 {

    /**
     * 最长公共字前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String minStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }
        if (minStr.length() == 0) {
            return "";
        }
        for (int i = minStr.length(); i >= 0; i--) {
            String tmp = minStr.substring(0, i);
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(tmp)) {
                    break;
                }
                count++;
            }
            if (count == strs.length) {
                return tmp;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"a"};
        Solution14 solution14 = new Solution14();
        String s = solution14.longestCommonPrefix(strings);
        System.out.println(s);
    }
}
