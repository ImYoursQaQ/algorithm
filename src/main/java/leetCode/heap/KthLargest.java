package leetCode.heap;

import java.util.PriorityQueue;

/**
 *  703,找第k大元素
 */
public class KthLargest {

    private int k;

    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.offer(val);
        }else if (val > queue.peek()){
                queue.poll();
                queue.add(val);
        }
        return queue.peek();
    }
}
