package leetCode.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;

/**
 * 98. 验证二叉搜索树
 */
class Solution {
    public static boolean isValidBST(TreeNode root) {
        Integer min = null,max=null;
        return doValid(root,min,max);
    }

    /**
     *
     * @param root
     * @param min-中序的前驱节点
     * @param max-中序的后驱节点
     * @return
     */
    private static boolean doValid(TreeNode root, Integer min, Integer max) {
        if (root == null)return true;
        if (min!=null && root.val<=min)return false;
        if (max!=null && root.val>=max) return false;
        return doValid(root.left,min,root.val)&&
                doValid(root.right,root.val,max);
    }


    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);

        TreeNode node11 = new TreeNode(11);
        TreeNode node20 = new TreeNode(20);

        TreeNode node6 = new TreeNode(6);
        TreeNode node12 = new TreeNode(12);

        node10.left = node5;    node10.right = node15;
        node15.left = node11; node15.right = node20;
        node11.left = node6; node11.right = node12;
        System.out.println(isValidBST(node10));
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}