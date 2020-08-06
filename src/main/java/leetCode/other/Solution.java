package leetCode.other;

import java.util.Arrays;

/**
 * @author hubo
 * @date 2020-07-29
 * @description:
 */

public class Solution {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[length/2];
    }
}
