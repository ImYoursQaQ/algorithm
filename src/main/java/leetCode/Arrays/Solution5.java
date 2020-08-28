package leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 234 回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return  false;
        }
        boolean res = true;
        ListNode pre = head;
        List<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        int low = 0,high = list.size()-1;
        while (low < high){
           if( list.get(low).intValue() != list.get(high).intValue()){
               res = false;
               break;
           } else {
               low ++;
               high --;
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