package leetCode.Arrays;

/**
 * [53]最大子数组和
 */
class Solution53 {

    /**
     * 利用正数增益问题
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            sum = Math.max(pre,sum);
        }
        return sum;
    }
}