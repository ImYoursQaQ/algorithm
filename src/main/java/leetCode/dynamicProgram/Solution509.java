package leetCode.dynamicProgram;

/**
 * 动态规划入门
 */
public class Solution509 {


    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        /**
         * 这里注意多申请一个
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution509().fib(3));
    }
}
