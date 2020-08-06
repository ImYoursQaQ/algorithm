package leetCode.bitCount;

class Solution5{
    public int[] countBits(int num) {
        if(num == 0)return new int[]{0};
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }
}