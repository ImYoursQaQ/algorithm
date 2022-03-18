package leetCode.search;

/**
 * 704 二分查找
 */
class Solution704 {

    /**
     * 普通的二分查找
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 在有重复元素的排序数组中找第一个符合要求的元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchFirst(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] nums = {1, 1, 3, 4, 5, 5, 6, 8, 10};
        System.out.println(solution704.searchFirst(nums, 1));
    }
}