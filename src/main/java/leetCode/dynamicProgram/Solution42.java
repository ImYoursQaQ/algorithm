package leetCode.dynamicProgram;

/**
 * 42 接雨水
 */
public class Solution42 {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int res = 0;
        int length = height.length;
        int[] leftMax = new int[length];
        //初始化左边界
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Integer.max(leftMax[i - 1], height[i]);
        }
        //初始化右边界
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Integer.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < length; i++) {
            res += Integer.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
