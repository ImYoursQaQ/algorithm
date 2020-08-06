package leetCode.dynamicProgram;

/**
 * 121. 买卖股票的最佳时机
 */
class Solution3 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int curMin = prices[0],resMax=0;
        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin,prices[i]);
            resMax = Math.max(resMax,prices[i] - curMin);
        }
        return resMax;

    }
}