package leetCode.map;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    /**
     * 利用map 计数 完成两数和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (map.containsKey(b) && i != map.get(b)) {
                return new int[]{i, map.get(b)};
            }
        }
        return new int[0];
    }
}