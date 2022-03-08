package leetCode.dynamicProgram;

import java.util.List;

public class Solution120 {

    /**
     * 动态规划问题
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //定义 dp
        int size = triangle.size();
        int[][] dp = new int[size][size];
        //初始化
        for (int i = 0; i < size; i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }
        //动态转移
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        //结束
        return dp[0][0];
    }
}
