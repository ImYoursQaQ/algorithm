package leetCode.listNode;

/**
 * @author teohubo
 */
public class Solution22 {

    /**
     * 两次遍历法，官方解法中有快慢指针法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0){
            return null;
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        cur = head;
        int end = count - k;
        for (int i = 0; i < end; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
