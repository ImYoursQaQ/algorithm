package leetCode.Arrays;

/**
 * 青蛙过河问题
 */
public class SolutionOther {

    public int canCross(int[] stones) {
        if(stones.length == 0){
            return 0;
        }
        int n = stones.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }
        dp[0] = stones[0];
        for(int i = 3; i < n; i ++){
            Integer min = null;
            for(int j = 5; j >=3; j --){
                if (i - j >= 0 && dp[i - j] != -1){
                    min = min == null ? dp[i - j]:Integer.min(dp[i - j],min);
                }
            }
            dp[i] = min == null ? -1 : min + stones[i];
        }
        return  dp[n-1];
    }

    public static void main(String[] args) {
        SolutionOther other = new SolutionOther();
        int[] nums = {0,1,3,5,6,8,12,17,5};
        System.out.println(other.canCross(nums));
    }
}
