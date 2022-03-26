package leetCode.listNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution23 {

    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            //空的跳过
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode pre  = new ListNode(-1);
        ListNode cur  = pre;
        while(!queue.isEmpty()){
            ListNode tmp = queue.poll();
            cur.next = new ListNode(tmp.val);
            cur = cur.next;
            //空的跳过
            if (tmp.next != null){
                queue.add(tmp.next);
            }
        }
        return pre.next;
    }
}
