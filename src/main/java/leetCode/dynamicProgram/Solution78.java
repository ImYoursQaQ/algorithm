package leetCode.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teohubo
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        //循环枚举法
        List<List<Integer>>  res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        subsets.forEach(System.out::println);
    }
}
