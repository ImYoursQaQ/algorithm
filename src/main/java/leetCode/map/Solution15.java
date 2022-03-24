package leetCode.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 15 三数和
 */
class Solution15 {

    /**
     * 使用map 解决三数和问题，缺点，排序阶段会超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                int c = -(a + b);
                if (map.containsKey(c) && map.get(c) != i && map.get(c) != j) {
                    int[] arr = new int[]{a, b, c};
                    Arrays.sort(arr);
                    List<Integer> tmp = Arrays.stream(arr).boxed().collect(Collectors.toList());
                    res.add(tmp);
                }
            }
        }
        return new ArrayList<>(res);
    }
}