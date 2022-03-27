package leetCode.dynamicProgram;

/**
 * @author teohubo
 */
public class Solution121 {

    /**
     * 买卖股票问题
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] leftMin = new int[prices.length];
        leftMin[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = Integer.min(leftMin[i - 1], prices[i]);
        }

        int[] rightMax = new int[prices.length];
        rightMax[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rightMax[i] = Integer.max(rightMax[i + 1], prices[i]);
        }

        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Integer.max(res, rightMax[i] - leftMin[i]);
        }
        return res;
    }
}
