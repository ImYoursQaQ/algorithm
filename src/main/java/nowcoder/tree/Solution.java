package nowcoder.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已知某棵树的某节点p，求该树在中序序列中的p后面的节点；
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {

    static List index = new ArrayList();
    static Map<Integer, TreeLinkNode> indexMap = new HashMap<>();

    public static void main(String[] args) {
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node11 = new TreeLinkNode(11);
        node5.left = node6; node5.right = node7;
        node6.left = node8; node6.right = node10;
        node7.right = node9;
        node9.right = node11;

        node6.next = node7.next = node5;
        node8.next = node10.next = node6;
        node9.next = node7;
        node11.next = node9;
        TreeLinkNode treeLinkNode = GetNext(node11);
        //
        System.out.println(index);
        if (treeLinkNode!=null){
            System.out.println(treeLinkNode.val);
        }else {
            System.out.println(treeLinkNode);
        }

    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {

        int val = pNode.val;
        //找根结点
        while (pNode.next != null) {
            pNode = pNode.next;
        }

        inOrder(pNode);
        int i = index.indexOf(val);
        if (i == index.size() - 1) {
            return null;
        }
        TreeLinkNode treeLinkNode = indexMap.get(index.get(i + 1));
        return treeLinkNode;
    }

    //生成中序序列
    private static void inOrder(TreeLinkNode pNode) {
        if (pNode!=null){
            inOrder(pNode.left);
            index.add(pNode.val);
            indexMap.put(pNode.val, pNode);
            inOrder(pNode.right);
        }

    }
}