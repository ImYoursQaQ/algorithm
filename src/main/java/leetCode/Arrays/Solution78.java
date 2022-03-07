package leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teohubo
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> lists = solution78.subsets(nums);
        lists.forEach(System.out::println);
    }
}
