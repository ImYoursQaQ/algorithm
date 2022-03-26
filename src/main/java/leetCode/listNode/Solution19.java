package leetCode.listNode;

public class Solution19 {

    /**
     * 移除链表倒数第 k 个元素
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        for(int i= 0; i < n ; i ++){
            fast = fast.next;
        }
        while (fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return pre.next;

    }
}
