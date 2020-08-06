package leetCode.hashtable;

/**
 * @author hubo
 * @date 2020-07-28
 * @description:
 */

import java.util.HashMap;

/**
 * 1。两数之和
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && i !=map.get(key) ){
                result[0] = i;
                result[1] = map.get(key);
                break;
            }

        }
        return result;
    }
}
