package leetCode.listNode;

/**
 *
 * [2]两数相加
 * @author teohubo
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;
    }

    /**
     * 1。同时遍历两个链表
     * 2。使用 pre 记录头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum > 9 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }

}
