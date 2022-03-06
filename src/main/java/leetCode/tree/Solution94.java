package leetCode.tree;

import java.util.ArrayList;
import java.util.List;


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


}
