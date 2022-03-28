package leetCode.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author teohubo
 */
public class Solution128 {
    /**
     * 利用栈查找最长不重复序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> sets = new HashSet<>();
        for (int j : nums) {
            sets.add(j);
        }
        int res = 0;
        for (Integer num : sets) {
            int cur = num;
            if (!sets.contains(cur - 1)) {
                while (sets.contains(cur + 1)) {
                    cur++;
                }
            }
            res = Integer.max(res, cur - num + 1);
        }
        return res;
    }
}
