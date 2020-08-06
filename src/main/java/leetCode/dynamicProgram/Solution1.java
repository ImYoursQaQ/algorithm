package leetCode.dynamicProgram;

import java.util.Arrays;
import java.util.List;

class Solution1 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int m = triangle.size();
        int[][] dp = new int[m][m];
        //最后一行需要初始化
        List<Integer> list = triangle.get(triangle.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            dp[triangle.size() - 1][i] = list.get(i);
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = i; j >= 0 ; j--) {
                dp[i][j] =triangle.get(i).get(j)+ Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    private static Integer minOf(int i, int j) {
        return i - j <= 0? i:j;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),
                                                    Arrays.asList(3,4),
                                                    Arrays.asList(6,5,7),
                                                    Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }
}