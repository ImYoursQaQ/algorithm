package sort.quickSort;


/**
 * @author teohubo
 */
public class Solution {

    public void sort(int[] nums){
        if (nums.length == 0){
            return;
        }
        int low = 0,high = nums.length -1;
        quickSort(nums,low,high);
    }

    public void quickSort(int[] nums,int low,int high){
      if (low >= high){
          return;
      }
      int k = part(nums,low,high);
      quickSort(nums,low,k -1);
      quickSort(nums, k + 1, high);
    }

    private int part(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high){
            while (low < high && nums[high] >= tmp){
                high --;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= tmp){
                low ++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }
}
