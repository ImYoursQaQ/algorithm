package leetCode.listNode;

/**
 * @author teohubo
 */
public class Solution206 {

    /**
     *  反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null,cur = head;
        while (cur != null){
            //利用临时节点记录下一个
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
