package leetCode.dynamicProgram;

/**
 * 动态规划习题
 */
public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //定义 dp
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return 1 - obstacleGrid[m - 1][n - 1];
        }
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        //初始化
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = obstacleGrid[m - 1][i] == 1 || dp[m - 1][i + 1] == 0 ? 0 : 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = obstacleGrid[i][n - 1] == 1 || dp[i + 1][n - 1] == 0 ? 0 : 1;
        }
        //动态转移
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[j][i] = obstacleGrid[j][i] == 1 ? 0 : dp[j][i + 1] + dp[j + 1][i];
            }
        }
        //返回结果
        return dp[0][0];
    }
}
