package leetCode.sort;

import java.util.Arrays;

/**
 * @author teohubo
 *
 * 283 移动零
 */
public class Solution283 {

    /**
     * 交换排序的应用
     * 使用双指针法可以快速实现
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int i1 = i;
                for (int j = i +1; j < nums.length; j++) {
                    if (nums[j] == 0){
                        continue;
                    }
                   int tmp = nums[j];
                   nums[j] = 0;
                   nums[i1] = tmp;
                   i1 ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = new int[]{0,0,1};
        solution283.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
