package leetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长字串
 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Map<Character, Integer> myMap = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if (myMap.containsKey(tmp)) {
                start = Integer.max(start, myMap.get(tmp) + 1);
            }
            res = Integer.max(res, i - start + 1);
            myMap.put(tmp, i);
        }
        return res;
    }

}
