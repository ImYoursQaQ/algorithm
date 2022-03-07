package leetCode.listNode;

/**
 * @author teohubo
 */
public class Solution21 {

    /**
     * 双指针移动链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode p = list1, q = list2;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = new ListNode(p.val);
                p = p.next;
            } else {
                cur.next = new ListNode(q.val);
                q = q.next;
            }
            cur = cur.next;
        }

        while (p != null) {
            cur.next = new ListNode(p.val);
            cur = cur.next;
            p = p.next;
        }

        while (q != null) {
            cur.next = new ListNode(q.val);
            cur = cur.next;
            q = q.next;
        }
        return head.next;
    }
}
