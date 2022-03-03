package leetCode.listNode;

/**
 * 24题，链表俩俩交换
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode node3 = node2.next;

        node2.next = node1;
        node1.next = swapPairs(node3);

        return node2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution24 solution24 = new Solution24();
        ListNode newNode = solution24.swapPairs(node1);
        while (newNode != null){
            System.out.println(newNode.val);
        }

    }
}