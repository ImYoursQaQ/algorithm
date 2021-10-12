package leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author hubo
 * @date 2020-07-30
 * @description:
 */

public class Solution3 {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        doDFS(root,res,1);
        return res;
    }

    private void doDFS(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() < level){
            res.add(Collections.<Integer>emptyList());
        }
        res.get(level-1).get(root.val);
        doDFS(root.left,res,level+1);
        doDFS(root.right,res,level+1);
    }

    /**
     * 求最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        int leftH = 0,rightH = 0;
        if (root.left !=null){
             leftH = maxDepth(root.left);
        }
        if (root.right !=null){
             rightH = maxDepth(root.right);
        }

        return leftH >= rightH? leftH+1:rightH+1;
    }

    /**
     * 求最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return doDFSMinDepth(root,1);
    }

    private int doDFSMinDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null){
            return depth;
        }

        int leftD = 0,rightD = 0;
        int res = 0;
        if (root.left != null && root.right != null) {
             leftD = doDFSMinDepth(root.left, depth + 1);
            rightD = doDFSMinDepth(root.right, depth+1);
            res =  leftD<=rightD?leftD:rightD;
        }
        if (root.left != null && root.right == null){
            res =  doDFSMinDepth(root.left,depth+1);
        }
        if (root.left == null && root.right != null){
            res =  doDFSMinDepth(root.right,depth+1);
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null){
        return Collections.EMPTY_LIST;
    }
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()){
        if (root!=null){
            stack.push(root);
            root = root.left;
        }else {
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }
    return list;
    }

    static boolean res = true;
    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) +1;
        if (Math.abs(left-right) >1){
            res = false;
        }
        return Math.max(left,right);


    }

    public static void main(String[] args) {
        boolean balanced = isBalanced(null);
        System.out.println(balanced);

    }


}
