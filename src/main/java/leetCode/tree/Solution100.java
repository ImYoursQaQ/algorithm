package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution100 {


    /**
     * 利用dfs 实现 相同的树，结构和数据必须都一样
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)
                && isSameTree(p.right, q.right);
    }

    /**
     * 标准dfs 实现
     * @param valueOne
     * @param p
     */
    private void dfs(List<Integer> valueOne, TreeNode p) {
        if (p == null){
            return;
        }
        valueOne.add(p.val);
        dfs(valueOne, p.left);
        dfs(valueOne, p.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        Solution100 solution100 = new Solution100();
        List<Integer> res = new ArrayList<>();
        solution100.dfs(res,node1);
        res.forEach(System.out::println);
    }



}
