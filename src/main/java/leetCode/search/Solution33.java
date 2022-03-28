package leetCode.search;

/**
 * @author teohubo
 */
public class Solution33 {
    /**
     *  二分查找的变种
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] >= nums[0]){
                //作半区
                if (nums[lo] <= target && target < nums[mid]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{
                //右半区
                if (nums[mid] < target && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}


