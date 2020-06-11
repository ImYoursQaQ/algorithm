package nowcoder.tree;

/**
 * @author hubo
 * @date 2020-06-10
 * @description:
 */

import java.util.*;

/**
 * 重建二叉树
 */
public class Class1 {
   static Map<Integer,Integer> indexMap = new HashMap<>();


    public static void main(String[] args) {

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, middle);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i],i);
        }
        return doReConstructBinaryTree(pre,0,pre.length-1,0);
    }

    private static TreeNode doReConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        Integer index = indexMap.get(pre[preL]);
        int length  = index-inL;
        root.left = doReConstructBinaryTree(pre,preL+1,preL+length,inL);
        root.right = doReConstructBinaryTree(pre,preL+1+length,preR-1,inL+length+1);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left ;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
