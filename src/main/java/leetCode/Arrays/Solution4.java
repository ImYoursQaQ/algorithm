package leetCode.Arrays;


import java.util.Arrays;

public class Solution4 {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, sum, 0, nums1.length);
        System.arraycopy(nums2, 0, sum, nums1.length, nums2.length);
        Arrays.sort(sum);
        boolean isSinge = sum.length % 2 == 1;
        int mid = sum.length / 2;
        if (isSinge) {
            return sum[mid];
        }
        return ((double) sum[mid] + (double) sum[mid - 1]) / 2;
    }
}
