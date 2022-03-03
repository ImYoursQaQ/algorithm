package leetCode.listNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author teohubo
 *
 * 141 环形链表判断
 */
public class Solution141 {

    /**
     *  答案推荐快慢指针法。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        Set valueSet = new HashSet();
        ListNode cur  = head;
        while(cur != null){
            if(valueSet.contains(cur.val)){
                return true;
            }
            valueSet.add(cur.val);
            cur = cur.next;
        }

        return false;
    }
}
