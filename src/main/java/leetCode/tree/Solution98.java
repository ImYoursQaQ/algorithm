package leetCode.tree;

/**
 * 98，验证二叉搜索树
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return doValidLeft(left, val)
                && doValidRight(right, val);

    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doValidBST(root,null,null);

    }

    private boolean doValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return doValidBST(root.left,min, root.val)
                && doValidBST(root.right, root.val,max);
    }

    private boolean doValidRight(TreeNode right, int val) {
        if (right == null) {
            return true;
        }
        if (right.val <= val) {
            return false;
        }
        return doValidRight(right.right, val)
                && doValidRight(right.left, val)
                && doValidLeft(right.left, right.val)
                && doValidRight(right.right, right.val);
    }

    private boolean doValidLeft(TreeNode left, int val) {
        if (left == null) {
            return true;
        }
        if (left.val >= val) {
            return false;
        }
        return doValidLeft(left.left, val)
                && doValidLeft(left.right, val)
                && doValidLeft(left.left, left.val)
                && doValidRight(left.right, left.val);
    }

}
