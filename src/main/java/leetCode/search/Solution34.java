package leetCode.search;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = nums[mid];
            if (tmp > target) {
                right = mid - 1;
            } else if (tmp < target) {
                left = mid + 1;
            } else {
                // 相等了
                if (mid == 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                } else {
                    right = mid - 1;
                }

            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = nums[mid];
            if (tmp > target) {
                right = mid - 1;
            } else if (tmp < target) {
                left = mid + 1;
            } else {
                // 相等了
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
