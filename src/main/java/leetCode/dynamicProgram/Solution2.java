package leetCode.dynamicProgram;

/**
 * 152. 乘积最大子数组
 * 采用的动态规划，并且压缩dp数据集
 */
class Solution2 {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0)return 0;
        if (nums.length == 1) return nums[0];
        int length = nums.length;
        int res = nums[0];
        int[] dp = new int[length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i <length ; i++) {
            for (int j = 0; j < length -i; j++) {
                res = Math.max(res,nums[i+j]);
                dp[j] = dp[j] * nums[i+j];
                res = Math.max(res,dp[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2};
        System.out.println(maxProduct(nums));
    }
}