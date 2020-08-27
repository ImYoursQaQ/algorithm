package leetCode.sort;

/**
 * 排序问题
 */
class Solution {

    /**
     * 归并排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tmp = new int[m+n];
        int i = 0,j = 0,k = 0;
        while (i < m && j < n){
            if (nums1[i] <= nums2[j]){
                tmp[k++] = nums1[i++];
            }else {
                tmp[k++] = nums2[j++];
            }
        }
        //判断哪一个有剩余
        while (i < m){
            tmp[k++] = nums1[i++];
        }
        while (j < n){
            tmp[k++] = nums2[j++];
        }
        for (int i1 = 0; i1 < tmp.length; i1++) {
            nums1[i] = tmp[i];
        }

    }

    public static int partition(int[] num,int p, int r){
        int pivot = num[r];
        int i = p;
        for (int j = i; j < r; j++) {
            if (num[j] < pivot){
                swap(num,i,j);
                i++;
            }
        }
        swap(num,i,r);
        return i;
    }

    private static void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{6,11,3,9,8};
        int partition = partition(ints, 0, ints.length - 1);
        System.out.println(partition);
    }
}