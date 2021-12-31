package leetCode.tree;

/**
 * [101] 对称二叉树
 * @author teohubo
 */
public class Solution101 {


    public boolean isSymmetric(TreeNode root) {
       return check(root,root);
    }

    /**
     * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，pp 指针和 qq 指针一开始都指向这棵树的根，随后 pp 右移时，
     * qq 左移，pp 左移时，qq 右移。每次检查当前 pp 和 qq 节点的值是否相等，如果相等再判断左右子树是否对称。
     *
     * [同步移动法]
     * @param pNode
     * @param qNode
     * @return
     */
    private boolean check(TreeNode pNode, TreeNode qNode) {
        if (pNode == null && qNode == null){
            return true;
        }
        if (pNode == null || qNode == null){
            return false;
        }
        return pNode.val == qNode.val && check(pNode.left,qNode.right) && check(pNode.right,qNode.left);
    }
}
