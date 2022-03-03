package leetCode.tree;

/**
 * @author teohubo
 * 108，递归、分治、平衡二叉树定义
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
       return dfs(nums,0,nums.length-1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if (low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums,low,mid-1);
        treeNode.right = dfs(nums,mid+1,high);
        return treeNode;
    }
}
