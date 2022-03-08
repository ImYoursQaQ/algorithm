package leetCode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author teohubo
 */
public class Solution3 {


    /**
     * 最长不重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if ( s == null || "".equals(s)){
            return 0;
        }
        int length = s.length();
        int max = 1;
        //首先把所有的无重复子串找出来
        for (int i = 0; i < length; i++) {
            Set<Character> chars = new HashSet<>();
            chars.add(s.charAt(i));
            for (int j = i + 1; j < length; j++) {
                char c = s.charAt(j);
                if (chars.contains(c)){
                    break;
                }else {
                    chars.add(c);
                }
            }
            max = Integer.max(max,chars.size());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String str = "a";
        System.out.println(solution3.lengthOfLongestSubstring(str));
    }
}
