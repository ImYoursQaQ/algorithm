package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {

    public List<Integer> preOrderTree(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        //初始化栈
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                cur = tmp.right;
            }
        }
        return res;
    }
}
