package leetCode.Collections;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

    PriorityQueue<Integer> queue;
    int limit;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.limit = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (queue.size()<limit){
            queue.add(val);
        }else if (val > queue.peek().intValue()){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}