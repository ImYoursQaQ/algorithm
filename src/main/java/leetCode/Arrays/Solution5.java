package leetCode.Arrays;

class Solution{
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0,high = nums.length-1;
        int res = -1;
        while (low<= high){
            int mid = low + (high-low)/2;
            if (nums[mid] > target){
                high = mid-1;
            }else if (nums[mid] < target){
                low = mid +1;
            }else {
                res = mid;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        int target = 8;
        System.out.println(search(nums,target));
    }
}