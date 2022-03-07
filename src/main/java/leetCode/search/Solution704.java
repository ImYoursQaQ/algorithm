package leetCode.search;

/**
 * 704 二分查找
 */
class Solution704 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}