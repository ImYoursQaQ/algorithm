package leetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author teohubo
 *
 * 下一个排列
 */
public class Solution31 {

    /**
     * 暴力dfs法
     * @param num
     * @return
     */
    public int findRes(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        boolean[] used = new boolean[nums.length];
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, "", num, used,res);
        res.sort(Integer::compareTo);
        return res.get(0);
    }

    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1, k = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (j == 0){
            Arrays.sort(nums, j, nums.length);
            for (int num : nums) {
                System.out.print(num +" ");
            }
            return;
        }
        while (k >= j) {
            if (nums[k] > nums[i]) {
                break;
            } else {
                k--;
            }
        }
        //swap
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
        //左闭右开
        Arrays.sort(nums, j, nums.length);
        for (int num : nums) {
            System.out.print(num +" ");
        }
    }

    private void dfs(char[] nums, int depth, String tmp,int num, boolean[] used,List<Integer> res) {
        if (depth == nums.length) {
            int value = Integer.parseInt(tmp);
            if (value > num) {
                res.add(value);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmp += nums[i];
                used[i] = true;
                dfs(nums, depth + 1, tmp, num, used,res);
                tmp = tmp.substring(0, tmp.length() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int res = solution31.findRes(11365);
        //System.out.println(res);
        int[] nums = {5,4,3,2,1};
        solution31.nextPermutation(nums);
    }
}
