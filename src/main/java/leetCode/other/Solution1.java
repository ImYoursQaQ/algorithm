package leetCode.other;

/**
 * @author hubo
 * @date 2020-07-29
 * @description:
 */

import java.util.Arrays;

/**
 * 贪心算法求解股票问题
 */
public class Solution1 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                sum +=prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
