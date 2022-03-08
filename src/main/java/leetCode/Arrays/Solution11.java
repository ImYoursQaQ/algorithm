package leetCode.Arrays;

public class Solution11 {

    /**
     * 利用双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length == 0){
            return 0;
        }
        int left = 0,right = height.length-1,res = 0;
        while (left < right){
            int tmp = Integer.min(height[left], height[right]) * (right - left);
            res = Integer.max(res,tmp);
            if (height[left] <= height[right]){
                left ++;
            }else {
                right --;
            }
        }
        return res;
    }
}
