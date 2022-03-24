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
        //大顶堆初始化
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < res.length + 1 -k ; i++) {
            if (queue.size() == k) {
                //队列满，移除窗口左边元素
                queue.remove(nums[i - 1]);
            }
            while (queue.size() < k) {
                //添加k 个新元素
                queue.add(nums[j++]);
            }
            //自动弹出当前最大元素
            res[i] = queue.peek();
        }

        return res;
    }
}