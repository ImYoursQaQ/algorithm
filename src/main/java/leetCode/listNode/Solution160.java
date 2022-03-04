package leetCode.listNode;

/**
 * 160 相交链表
 *
 * 答案是个技巧题
 *
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        while (curA != null) {
            ListNode curB = headB;
            while (curB != null) {
                if (curB == curA) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
        }
        return null;
    }
}