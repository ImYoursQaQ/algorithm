package leetCode.search;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,8,6,5};
        Solution solution = new Solution();
        System.out.println(solution.findMax(nums));
    }

    /**
     *  nums : 1 2 3 4 8 6 5;
     * @param nums
     * @return
     */
    public int findMax(int[] nums){
        int left = 0,right = nums.length -1;
        int target = -1;
        while ( left <= right){
            int mid = (left + right)  / 2;
            if (nums[mid -1] < nums[mid] && nums[mid] > nums[mid + 1]){
                target = mid;
                break;
            }else if (nums[mid -1] < nums[mid] && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else if (nums[mid -1] > nums[mid] && nums[mid] > nums[mid + 1]){
                right = mid -1;
            }
        }

        if (target != -1){
            return nums[target];
        }

        return -1;
    }
}
