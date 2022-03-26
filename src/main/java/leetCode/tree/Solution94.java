package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root != null){
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }


    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //这里先把左节点全部进栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur = tmp.right;
            }
        }
        return res;
    }


}
