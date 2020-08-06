package leetCode.tree;

/**
 * @author hubo
 * @date 2020-07-29
 * @description:
 */

import java.util.Stack;

/**
 * 235. 二叉搜索树的最近公共祖先
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        //p,q都小于root节点，则去左子树中找
        if (root.val>p.val && root.val>q.val){
            return lowestCommonAncestor1(root.left,p,q);
        }
        //p,q都大于root节点，则去右子树中找
        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor1(root.right,p,q);
        }
        //此时root大于p，小于q，即为公共祖先
        return root;
    }

    public static int fiber(int n){
        //退出条件
        if (n == 1 || n==2){
            return 1;
        }
        //数据处理


        //子函数调用
        int fiber = fiber(n - 1);
        int fiber1 = fiber(n - 2);
        //处理子函数结果
        return fiber+fiber1;
    }

    public static void main(String[] args) {
        int fiber = fiber(15);
        System.out.println(fiber);
    }

}

