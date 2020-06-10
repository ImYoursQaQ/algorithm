package nowcoder.list;

/**
 * @author hubo
 * @date 2020-06-10
 * @description:
 */

import java.util.*;

/**
 * 从尾到头反过来打印出每个结点的值
 *
 *
 *
 */
public class Class1 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ArrayList<Integer> integers = printListFromTailToHead(node1);
        System.out.println(integers);

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<>();
        }
        ArrayList list = new ArrayList();
        Deque vector = new ArrayDeque() ;
        while (listNode.next!=null){
            vector.addFirst(listNode.val);
            listNode = listNode.next;
        }
        vector.addFirst(listNode.val);
        while (vector.size()>0){
            list.add(vector.pollFirst());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
