package sort.mergeSort;


import java.util.Arrays;

public class SolutionMerge {

    /**
     * 归并排序
     * @param nums
     */
    public int[] sort(int[] nums){
        if (nums.length == 0){
            return new int[0];
        }
        int left = 0,right = nums.length - 1;
        return mergeSort(nums,left,right);
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        //结束条件
        if ( left >= right){
            return new int[]{nums[left]};
        }
        int mid = ( left + right) / 2;
        int[] a = mergeSort(nums, left, mid);
        int[] b = mergeSort(nums,mid + 1,right);
        return doMerge(a,b);
    }

    private int[] doMerge(int[] a, int[] b) {
        if ( a.length == 0){
            return b;
        }
        if (b.length == 0){
            return a;
        }
        int i = 0, j = 0;
        int[] res = new int[a.length + b.length];
        int k = 0;
        while (i < a.length && j < b.length){
            int x = a[i];
            int y = b[j];
            if (x <= y){
                res[k++] = x;
                i ++;
            }else {
                res[k++] = y;
                j ++;
            }
        }
        while (i == a.length && j < b.length){
            res[k++] = b[j++];
        }

        while (i < a.length && j == b.length){
            res[k++] = a[i++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,9,4,3};
        SolutionMerge solutionMerge = new SolutionMerge();
        System.out.println(Arrays.toString(solutionMerge.sort(nums)));
    }
}
