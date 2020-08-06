package leetCode.hashtable;

/**
 * @author hubo
 * @date 2020-07-28
 * @description:
 */

import java.util.*;

/**
 * 15.三数之和
 */
public class Solution3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length<3){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left]+nums[right];
                if (sum>0){
                    right = right-1;
                }else if (sum<0){
                    left = left+1;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//       threeSum(nums);
        System.out.println( threeSum(nums).toString());
    }

}
