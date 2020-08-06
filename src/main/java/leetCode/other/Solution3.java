package leetCode.other;

/**
 * @author hubo
 * @date 2020-08-01
 * @description:
 */

public class Solution3 {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int left = 0,right = x;
        while (left<=right){
            int mid = (left+right)/2;
            if (mid == x/mid)return mid;
            if (mid >x/mid){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return (left+right)/2;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
