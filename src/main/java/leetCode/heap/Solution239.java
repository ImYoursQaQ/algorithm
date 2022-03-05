package leetCode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution239 {


    /**
     *利用最大堆实现滑动窗口，缺点：时间复杂度比较高
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (queue.size() == k) {
                queue.remove(nums[i - 1]);
            }
            while (queue.size() < k) {
                queue.add(nums[j++]);
            }
            res[i] = queue.peek().intValue();
        }

        return res;
    }
}